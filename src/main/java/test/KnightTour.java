package test;

import java.util.Arrays;

class KnightTour {
    static int R = 4;
    static int C = 8;
    public static String[] label = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};

    /* A utility function to check if i,j are
    valid indexes for N*N chessboard */
    static boolean isSafe(int x, int y, int sol[][]) {
        return ((x >= 0 && x < C && y >= 0 &&
                y < R )&& sol[x][y] == -1);
    }

    /* A utility function to print solution
    matrix sol[N][N] */
    static void printSolution(int sol[][]) {
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    /* This function solves the Knight Tour problem
    using Backtracking. This function mainly
    uses solveKTUtil() to solve the problem. It
    returns false if no complete tour is possible,
    otherwise return true and prints the tour.
    Please note that there may be more than one
    solutions, this function prints one of the
    feasible solutions. */
    static boolean solveKT(Point startPoint) {
        int sol[][] = new int[8][8];

        /* Initialization of solution matrix */

        // cleaning the board
        for (int row = R - 1; row >= 0; row--) {
            for (int column = 0; column <= C - 1; column++) {
                sol[row][column] = -1;
            }
        }


	/* xMove[] and yMove[] define next move of Knight.
		xMove[] is for next value of x coordinate
		yMove[] is for next value of y coordinate */
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // Since the Knight is initially at the first block
        sol[startPoint.r][startPoint.c] = 0;

		/* Start from 0,0 and explore all tours using
		solveKTUtil() */
        if (!solveKTUtil(startPoint.r, startPoint.c, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(sol);

        return true;
    }

    /* A recursive utility function to solve Knight
    Tour problem */
    static boolean solveKTUtil(int x, int y, int movei,
                               int sol[][], int xMove[],
                               int yMove[]) {
        int k, next_x, next_y;
        if (movei == R * C)
            return true;

		/* Try all next moves from the current coordinate
			x, y */
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1,
                        sol, xMove, yMove))
                    return true;
                else
                    sol[next_x][next_y] = -1; // backtracking
            }
        }

        return false;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        Point startPoint = new Point(0, 0, null);
        solveKT(startPoint);
    }

    public static String chess(int r, int c) {
        return label[c] + (r + 1);
    }

    private static class Point {
        int r, c;

        String path;

        Point(int r, int c, String path) {
            this.r = r;
            this.c = c;
            this.path = path != null ? path : chess(r, c);
        }
    }
}
