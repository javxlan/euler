package test;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    public int[][] board = new int[][]{
            {-1, -1, -1},
            {-1, -1, -1},
            {-1, -1, -1},
    };

    private String gameStatus = "continue";
    private boolean isFinish = false;

    public static void main(String[] args) {
        int k = 3;
        TicTacToe t = new TicTacToe();
        Scanner scanner = null;
        //(t.nextMove(1, 1, 1));
        int player = 1;
        while (!t.isFinish) {
            if (player > k) {
                player = 1;
            }

            System.out.println("player " + player + " please input here");
            scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x >= 0 && x < t.board.length && y >= 0 && y < t.board[0].length) {
                if (t.board[x][y] == -1) {
                    System.out.println(t.nextMove(x, y, player));
                    player++;
                    t.printBoard();
                } else {
                    System.out.println("this point has already taken, please input another point");
                }
            } else {
                System.out.println("pleas input point in a board");
            }
        }
    }

    private void printBoard() {
        for (int[] row : this.board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public String nextMove(int row, int column, int player) {
        // its starting point found 1
        this.board[row][column] = player;

        Direction[] dir = new Direction[4];

        Point top = new Point(0, -1);
        Point down = new Point(0, 1);
        Point left = new Point(-1, 0);
        Point right = new Point(1, 0);
        Point leftTop = new Point(-1, -1);
        Point rightBottom = new Point(1, 1);
        Point rightTop = new Point(1, -1);
        Point leftBottom = new Point(-1, 1);

        dir[1] = new Direction(top, down, "Vertical line");
        dir[0] = new Direction(left, right, "Horizontal line");
        dir[2] = new Direction(leftTop, rightBottom, "From left top to right bottom");
        dir[3] = new Direction(rightTop, leftBottom, "From right top to left bottom");

        gameStatus = "Next player ";

        for (Direction direction : dir) {
            int countStart = checkGameOver(row, column, player, 0, direction.start);
            int countEnd = checkGameOver(row, column, player, 0, direction.end);
            //remove duplicate count -1
            countStart--;
            if ((countStart + countEnd) == this.board.length) {
                gameStatus = "Game is over. Winner by player=" + player + ", " + direction.description;
                isFinish = true;
                break;
            }
        }

        return gameStatus;
    }

    public boolean isSafe(int row, int column) {
        return (row >= 0 && row < this.board.length && column >= 0 && column < this.board[0].length);
    }

    public int checkGameOver(int row, int column, int player, int counter, Point p) {
        if (isSafe(row, column) && this.board[row][column] == player) {
            return checkGameOver(row + p.y, column + p.x, player, counter + 1, p);
        } else {
            return counter;
        }
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Direction {
    Point start, end;
    String description;

    Direction(Point start, Point end, String description) {
        this.start = start;
        this.end = end;
        this.description = description;
    }
}