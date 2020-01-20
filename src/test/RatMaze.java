package test;

import java.util.Arrays;

class RatMaze {

    static int C = 8;
    static int R = 8;
    static int startX = 0;
    static int startY = 0;
    static int destX = 3;
    static int destY = 3;

    public static int[][] initBoard(int[][] sol) {
        for (int x = 0; x < C; x++) {
            for (int y = 0; y < R; y++) {
                sol[x][y] = 0;
            }
        }
        return sol;
    }

    public static void solvePath() {

        if (destY == startY && destX == startX) {
            System.out.println("duplicated points");
            return;
        }

        int[][] sol = new int[R][C];
        // board initiated
        sol = initBoard(sol);

        // setting the starting position
        sol[startX][startY] = 1;


        //building blocks
        sol[0][1] = 2;
        sol[2][0] = 2;
        sol[0][2] = 2;
        sol[1][2] = 2;
        sol[2][2] = 2;

        System.out.println("\n ****************** Game is started ********************* \n");
        printBoard(sol);


        if (findGate(sol, startX, startY))
            printBoard(sol);
        else
            System.out.println("no path");

    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }


    public static boolean findGate(int[][] sol, int x, int y) {
        int xMove[] = {0, 1, 0, -1};
        int yMove[] = {-1, 0, 1, 0};

        // is reached out the destination
        if (destX == x && destY == y) {
            System.out.println("\n ***** rat is winner ******** \n");
            return true;
        }

        // looping through adjacent cells
        for (int i = 0; i < 4; i++) {
            int nextX = x + xMove[i];
            int nextY = y + yMove[i];

            if (isSafe(nextX, nextY, sol)) {
                // marked visited
                sol[nextX][nextY] = 1;
                if (findGate(sol, nextX, nextY)) {
                    return true;
                } else {
                    // backtracking in other word marked failed path
                    sol[nextX][nextY] = 0;
                }
            }
        }

        // there is not available path
        return false;
    }


    public static boolean isSafe(int x, int y, int[][] sol) {

        // check is available
        if (x >= 0 && x < C && y >= 0 && y < R && sol[x][y] == 0) return true;
        return false;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        solvePath();
    }
}
