package leetcode.april;

public class Day9 {
    public static void main(String[] args) {
        System.out.println(new Day9().backspaceCompare("a##c", "#a#c"));
    }

    public boolean backspaceCompare(String S, String T) {
        return stripString(S).equals(stripString(T));
    }

    public String stripString(String str) {
        int backIndex = str.indexOf("#");
        if (backIndex == -1) return str;
        if (backIndex == 0) {
            str = str.substring(1, str.length());
        } else {
            String begin = str.substring(0, backIndex - 1);
            String end = str.substring(backIndex + 1, str.length());
            str = begin + end;
        }
        return stripString(str);
    }
}
// index = 2
// begin a   substr 0,1
// end c    substr 2,3


/***
 *  Backspace String Compare
 *
 *  Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 *
 * Can you solve it in O(N) time and O(1) space?
 *
 */

