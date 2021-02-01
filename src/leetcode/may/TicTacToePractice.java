package leetcode.may;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToePractice {

    int[][] board = new int[3][3];
    static int players = 2;

    public static void main(String[] args) {
        int i = 1, j = 1, player = 1;
        Scanner scanner = null;
        TicTacToePractice practice = new TicTacToePractice();
        while (practice.move(i, j, player)) {
            scanner = new Scanner(System.in);
            System.out.println("player " + player + " input row ");
            i = scanner.nextInt();
            System.out.println("player " + player + " input column ");
            j = scanner.nextInt();
            player++;
            if (player > players) player = 1;
            practice.print();
        }
    }


    public boolean move(int i, int j, int player) {
        if (!isSafe(i, j)) {
            System.out.println("Out of board");
            return true;
        }
        if (board[i][j] != 0) {
            System.out.println("It's already taken");
            return true;
        }
        // placing order
        board[i][j] = player;
        if (hasWin(i, j, player)) {
            System.out.println("Player " + player + " has won");
            return false;
        }
        return !isOver(i, j, player);
    }

    public boolean hasWin(int i, int j, int player) {
        // check vertical
        //if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
        if (i == 0) {
            if (checkUp(i, j, player, 2)) return true;
            if (checkUp(i, j, player, 3) && checkUp(i, j, player, 4)) return true;
        }
        if (i == board.length - 1) {
            if (checkUp(i, j, player, 2)) return true;
            if (checkUp(i, j, player, 3) && checkUp(i, j, player, 4)) return true;
            return false;
        }

        if (checkUp(i, j, player, 1) && checkUp(i, j, player, 2)) return true;
        // check horizontal
        if (checkUp(i, j, player, 3) && checkUp(i, j, player, 4)) return true;
        // check diagonal - 1
        if (checkUp(i, j, player, 5) && checkUp(i, j, player, 8)) return true;
        // check diagonal - 2
        if (checkUp(i, j, player, 6) && checkUp(i, j, player, 7)) return true;

        return false;
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
    public boolean checkUp(int i, int j, int player, int direction) {
        if (!isSafe(i, j)) return true;
        if (board[i][j] != player) return false;

        if (direction == 1) return checkUp(i - 1, j, player, direction);
        if (direction == 2) return checkUp(i + 1, j, player, direction);
        if (direction == 3) return checkUp(i, j - 1, player, direction);
        if (direction == 4) return checkUp(i, j + 1, player, direction);
        if (direction == 5) return checkUp(i - 1, j - 1, player, direction);
        if (direction == 6) return checkUp(i - 1, j + 1, player, direction);
        if (direction == 7) return checkUp(i + 1, j - 1, player, direction);
        if (direction == 8) return checkUp(i + 1, j + 1, player, direction);
        return false;
    }


    public boolean isSafe(int i, int j) {
        return (i >= 0 && i < board.length && j >= 0 && j < board[0].length);
    }
}
