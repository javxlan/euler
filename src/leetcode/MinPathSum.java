package leetcode;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new MinPathSum().minPathSum(grid));
    }

    /**
     * There is mostly needed optimize solution solved by dynamic programming. For example minimizes, max, profit, best etc.
     * So I'm gonna solve this problem by DP
     */

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] += grid[i][j];

                if (i > 0 && j > 0) {
                    //current dp selects best cell among left or top cell.
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
