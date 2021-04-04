package leetcode.august;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath"};
        new WordSearch2().findWords(board, words);
    }

    public List<String> findWords(char[][] board, String[] words) {

        List<String> ans = new ArrayList<>();

        char[][] cp = new char[board.length][board[0].length];
        System.out.println("-------------------------");
        print(board);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                cp[i][j] = board[i][j];


        for (String word : words)
            if (findWord(cp, word))
                ans.add(word);
        //resetting new board
        cp = board;
        return ans;


        // loop over words
        //    find a wind
        //       if found add to answer
        //    board reset to initial board
        // return answer
    }


    public boolean findWord(char[][] board, String str) {
        boolean result = false;
        if (str.equals("") || str == null) return result;

        char[] word = str.toCharArray();
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word[0]) {
                    if (dfs(board, r, c, word, 0)) result = true;
                }
                if (result) break;
            }
        return result;
    }

    public boolean dfs(char[][] board, int r, int c, char[] word, int index) {

        // check inside of board
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '0'
                || (index < word.length && board[r][c] != word[index])) return false;

        char curChar = board[r][c];
        board[r][c] = '0';

        if (dfs(board, r - 1, c, word, index + 1)) ;
        if (dfs(board, r, c + 1, word, index + 1)) ;
        if (dfs(board, r + 1, c, word, index + 1)) ;
        if (dfs(board, r, c - 1, word, index + 1)) ;

        // backrack
        System.out.println("-------------------------");
        print(board);
        if (index == word.length - 1) {
            return true;
        } else {
            board[r][c] = curChar;
            return false;
        }
    }

    public void print(char[][] board) {
        for (char[] row : board) {
            System.out.println(String.valueOf(row));
        }
    }
}
