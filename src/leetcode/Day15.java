package leetcode;

public class Day15 {
    public static void main(String[] args) {
        int[][] shift = new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        System.out.println(new Day15().stringShift("", shift));
    }

    public String stringShift(String s, int[][] shift) {
        if (s == "") return s;
        for (int[] arr : shift) {
            s = shift(arr, s);
        }
        return s;
    }

    public String shift(int[] arr, String str) {
        for (int i = 0; i < arr[1]; i++) {
            if (arr[0] == 1) str = shiftLeft(str);
            else str = shiftRight(str);
        }
        return str;
    }

    public String shiftRight(String str) {
        str = str.substring(1, str.length()) + str.substring(0, 1);
        return str;
    }

    public String shiftLeft(String str) {
        str = str.substring(str.length() - 1, str.length()) + str.substring(0, str.length() - 1);
        return str;
    }
}

/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 * <p>
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 */