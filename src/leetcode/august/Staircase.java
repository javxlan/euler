package leetcode.august;

import java.util.ArrayList;
import java.util.List;

public class Staircase {
    public static void main(String[] args) {
        //
      System.out.println(new Staircase().climbStairs(12));
    }

    /**
     * Framework for Solving DP problems:
     * 1. Define the   objective function
     * 2. Identify the base cases
     * 3. Write down recursion relation for optimized objective function
     * 4. What's the order of execution?
     * 5. Where to look for the answer?
     */

    public int climbStairs(int n) {
        // 1. f(i)-is number of distinct ways to reach the i-th stair.
        int[] dp = new int[n + 1];
        // 2. f(0)=1 , f(1)=1

        dp[0] = 1;
        dp[1] = 1;

        // 3. f(n) = f(n-1) + f(n-2)

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 4. bottom-up approach. because is building solution based on previous computations

        // 5. f(n)

        return dp[n];

    }

}
