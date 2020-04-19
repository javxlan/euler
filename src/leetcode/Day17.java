package leetcode;

public class Day17 {
    public static void main(String[] args) {
        char[][] map = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println(new Day17().numIslands(map));
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // starting from mainland, not water
                if (grid[i][j] == '1') {
                    count++;
                    // Main approach is all explored lands are marked like as water.It means if a mainland found then it recursively run dfs until surround water,
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // the location check whether inside of boundary or not or surround water, it check the next location
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }
}

/***
 *   Number of Islands
 *
 *  Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent
 *  lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 * */