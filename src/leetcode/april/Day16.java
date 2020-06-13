package leetcode.april;

import java.util.Stack;

public class Day16 {

    public static void main(String[] args) {
        System.out.println(new Day16().checkValidString("**((*"));
    }

    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<Integer>();
        Stack<Integer> star = new Stack<Integer>();
        char[] arr = s.toCharArray();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (arr[i] == '(') {
                open.push(i);
            } else if (arr[i] == '*') {
                star.push(i);
            } else {
                if (!open.isEmpty()) {
                    //if it's not empty then remove open with paired close bracket
                    open.pop();
                } else if (!star.isEmpty()) {
                    //if there's no open brackets then next option is remove start with paired close bracket
                    star.pop();
                } else {
                    // here is started by close bracket case
                    return false;
                }
            }
        }

        while (!open.isEmpty()) {
            if (star.isEmpty()) {
                return false;
            } else if (open.peek() < star.peek()) {
                open.pop();
                star.pop();
            } else {
                return false;
            }

        }
        return true;
    }
}


/**
 * Valid Parenthesis String
 * <p>
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 * <p>
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
