package soti;

/**
 * If A8 in a chess board is black write an algorithm to tell the colour of given location.
 */
public class ChessBoard {
    public static void main(String[] args) {
        int N = 8;
        int[][] board = new int[N][N];
        // black
        int[] black = {0, 0};
        // ans
        int[] ans = {1, 6};

        int distance = Math.abs(black[0] - ans[0]) + Math.abs(black[1] - ans[1]);

        String answer = distance % 2 == 0 ? "black" : "white";
        System.out.println(answer);
    }


}
