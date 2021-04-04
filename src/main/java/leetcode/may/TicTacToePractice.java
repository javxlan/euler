package leetcode.may;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToePractice {

    int[][] board = new int[2][2];
    static int players = 2;

    public static void main(String[] args) {
        int i = 1, j = 1, player = 1;
        Scanner scanner = null;
        TicTacToePractice practice = new TicTacToePractice();

        scanner = new Scanner(System.in);
        System.out.println("player " + player + " input row ");
        i = scanner.nextInt();
        System.out.println("player " + player + " input column ");
        j = scanner.nextInt();


        while (practice.move(i, j, player)) {
            player++;
            if (player > players) player = 1;
            practice.print();

            System.out.println("player " + player + " input row ");
            i = scanner.nextInt();
            System.out.println("player " + player + " input column ");
            j = scanner.nextInt();

        }
    }


    public boolean move(int i, int j, int player) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            System.out.println("Out of board");
            return true;
        }
        if (board[i][j] != 0) {
            System.out.println("It's already taken");
            return true;
        }
        // placing order
        board[i][j] = player;
        int status = hasWin(i, j, player);
        System.out.println("status=" + status);
        if (status != 0) {
            System.out.println("player " + player + " won ");
            return false;
        }

        return !isOver(i, j, player);
    }

    public int hasWin(int row, int col, int player) {
        // check vertical
        //if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {

        if (countCell(row, col, player, 1) && countCell(row, col, player, 2)) return player;
        // check horizontal left&&right==true win
        if (countCell(row, col, player, 3) && countCell(row, col, player, 4)) return player;
        // check diagnal1 lefttop&&rightdown==true win
        if (row == col && countCell(row, col, player, 5) && countCell(row, col, player, 8) && (!(row == 0 && col == board[0].length - 1) && !(row == board.length - 1 && col == 0)))
            return player;
        // check diagnal2 leftdown&&righttop==true win
        if ((row + col + 1) == board.length && countCell(row, col, player, 6) && countCell(row, col, player, 7) && (!(row == 0 && col == 0) && !(row == board.length - 1 && col == board[0].length - 1)))
            return player;

        return 0;
    }

    public void print() {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public boolean isOver(int i, int j, int player) {
        for (int k = 0; k < board.length; k++) {
            for (int l = 0; l < board[k].length; l++) {
                if (board[k][l] == 0) return false;
            }
        }
        return true;
    }

    // direction  up= 1, down =2, left =3 right =4, left_top =5,right_top =6, left_down =7 , right_down =8
    public boolean countCell(int i, int j, int player, int direction) {
        //if (!isSafe(i, j)) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return true;

        if (board[i][j] != player) return false;

        if (direction == 1) return countCell(i - 1, j, player, direction);
        if (direction == 2) return countCell(i + 1, j, player, direction);
        if (direction == 3) return countCell(i, j - 1, player, direction);
        if (direction == 4) return countCell(i, j + 1, player, direction);
        if (direction == 5) return countCell(i - 1, j - 1, player, direction);
        if (direction == 6) return countCell(i - 1, j + 1, player, direction);
        if (direction == 7) return countCell(i + 1, j - 1, player, direction);
        if (direction == 8) return countCell(i + 1, j + 1, player, direction);
        return false;
    }


    public boolean isSafe(int i, int j) {
        return (i < 0 || i >= board.length || j < 0 || j >= board[0].length);
    }
}
