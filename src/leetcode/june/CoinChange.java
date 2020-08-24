package leetcode.june;

public class CoinChange {

    public static void main(String[] args) {
        change(5, new int[]{1, 2, 5});
    }

    public static int change(int amount, int[] coins) {
        int count = 0;

        /*int[][] dp = new int[amount + 1][coins.length + 1];

        for (int row = 0; row < dp.length; row++) {
            for (int col = 0; col < dp[0].length; col++) {
                if (row == 0) {
                    dp[row][col] = 1;
                } else if (col == 0) {
                    dp[row][col] = 0;
                } else {
                    System.out.println(row + " " + col);
                    dp[row][col] = dp[row - 1][col] + dp[row][col - coins[row - 1] >= 0 ? col - coins[row - 1] : 0];
                }
            }
        }*/

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; x++) {
                dp[x] += dp[x - coin];
            }
        }
        System.out.println(dp[amount]);
        return dp[amount];
    }
}
// 1,2,5
//5

/**
 * 0  1  2  3  4  5
 * [] 1  1  1  1  1  1
 * 1 0
 * 2 0
 * 5 0
 */