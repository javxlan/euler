package leetcode.august;

/**
 * * Given a 2D board and a word, find if the word exists in the grid.
 *
 * <p>The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells
 * are those horizontally or vertically neighboring. The same letter cell may not be used more than
 * once.
 */

//        Given word = "ABCCED", return true.
//        Given word = "SEE", return true.
//        Given word = "ABCB", return false.

public class WordSearch {
    private char[] str;

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
//        char[][] board = {{'a', 'b'}, {'c', 'd'}};
//        String word = "abcd";
        System.out.println(new WordSearch().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        boolean answer = false;
        this.str = word.toCharArray();
        // find starting point
        if (word.length() == 0 || word.isEmpty()) return answer;
        int index = 0;
        String backtrack = "";
        print(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // find starting point
                if (board[i][j] == str[0]) {


                    index = dfs(board, i, j, index, backtrack);

                    if (index == str.length - 1) {
                        answer = true;
                        break;
                    }
                }
                if (answer) break;
            }
        }
        return answer;
    }

    public int dfs(char[][] board, int i, int j, int index, String backtrack) {

        if (this.str.length <= index || i < 0
                || i >= board.length
                || j < 0
                || j >= board[0].length
                || board[i][j] == '0'
                || board[i][j] != this.str[index]) {
            return index - 1;
        }

        // mark as visited
        backtrack += board[i][j];
        char c = board[i][j];
        int temp = index;

        board[i][j] = '0';
        System.out.println("---------------------------");
        print(board);

        index = dfs(board, i - 1, j, index + 1, backtrack);
        index = dfs(board, i, j + 1, index + 1, backtrack);
        index = dfs(board, i + 1, j, index + 1, backtrack);
        index = dfs(board, i, j - 1, index + 1, backtrack);

        // end of dfs current dfs search.

        // should be mark as backtrack

        if (index != str.length - 1) {
            board[i][j] = c;
            index = index > 0 ? temp - 1 : index;
            System.out.println(index);
            backtrack = backtrack.substring(backtrack.length() - 1, backtrack.length());
        }

        return index;
    }


    public void print(char[][] board) {
        for (char[] row : board) {
            System.out.println(String.valueOf(row));
        }
    }
}
