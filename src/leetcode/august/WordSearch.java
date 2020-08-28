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
    String word = "ABCCED";
    System.out.println(new WordSearch().exist(board, word));
  }

  public boolean exist(char[][] board, String word) {
    boolean answer = false;
    this.str = word.toCharArray();
    // find starting point
    if (word.length() == 0 || word.isEmpty()) return answer;
    int index = 0;
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[i].length; j++) {
        index = dfs(board, i, j, index);
        System.out.println(index);
        if (index == str.length) answer = true;
        break;
      }

    return answer;
  }

  public int dfs(char[][] board, int i, int j, int index) {
    // int[][] adj = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // 0 = visited
    if (i < 0
        || i >= board.length
        || j < 0
        || j >= board[0].length
        || board[i][j] == '0'
        || board[i][j] != this.str[index]) {
      return index;
    }
    if (board[i][j] == this.str[index]) board[i][j] = '0';

    index = dfs(board, i - 1, j, index + 1);
    index = dfs(board, i, j + 1, index + 1);
    index = dfs(board, i + 1, j, index + 1);
    index = dfs(board, i, j - 1, index + 1);
    return index;
  }
}
