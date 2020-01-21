package test;

public class NumIslands {

    public static void main(String[] args) {
        NumIslands i = new NumIslands();

        //char[][] map = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] map = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        i.printMap(map);
        System.out.println(i.numIslands(map));
    }


    public int numIslands(char[][] grid) {

        if (grid.length == 0) return 0;

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                    System.out.println("");
                    printMap(grid);
                }
            }
        }
        return count;
    }


    private void dfs(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }

    private void printMap(char[][] map) {
        for (char[] row : map) {
            System.out.println(row);
        }
    }

}
