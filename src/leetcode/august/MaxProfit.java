package leetcode.august;

import java.util.Arrays;

public class MaxProfit {

    public static void main(String[] args) {
        // [1,3,2,8,4,9], 2/  8
        // [1,3,7,5,10,3] 3/  6
        int[] prices = {1, 4, 6, 2, 8, 3, 10, 14};
        new MaxProfit().maxProfit(prices, 3);
    }


    public int maxProfit(int[] prices, int fee) {
        // 1. Define objective function
        // 2. Identify base cases
        // 3. Recursion overlap optimized objective function
        // 4. Order of execution
        // 5. Locate answer

        // 1. f(i) is i-th of profit and fee(i)
        // 2. f(0) = 0 , f(1)=0 ,f(2) = max(p[2]-p[1],0) f(3) = max(p[3]-)
        // 3. f(i) =   max(p[i-1]-soFarMin,f(i-1)+p[i-1]-minRecent );
        // 4. bottom up
        // 5. dp[n]

        if (prices == null || prices.length < 2) return 0;

        int[] dp = new int[prices.length + 1];
        //int[] buy = new int[prices.length + 1];

        int buyMin = prices[0], mostRecentMin = prices[0];

        dp[0] = 0;

        for (int i = 1; i <= prices.length; i++) {
            int current = prices[i - 1];
            // cheapest > current
            if (buyMin > prices[i - 1]) buyMin = current;
            // recent cheaper
            //if (dp[i - 1] > prices[i - 1]) buyMin = prices[i - 1];
            if (mostRecentMin > current) mostRecentMin = current;

            // price[i] - cheapest >  dp[i-1] + (price[i] - mostRecentMin)
            if (current - mostRecentMin - fee > 0) {
                //dp[i] = dp[i - 1] + (prices[i - 1] - buyMin - fee);
                // buyMin = prices[i - 1];
                dp[i] = Math.max(current - buyMin - fee, dp[i - 1] + (current - mostRecentMin - fee));
                mostRecentMin = current;
            } else {
                dp[i] = dp[i - 1];
            }

            System.out.println(Arrays.toString(dp) + "         " + Arrays.toString(prices)+" "+mostRecentMin);
        }
        return dp[prices.length];
    }

}
