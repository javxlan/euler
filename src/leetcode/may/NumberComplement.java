package leetcode.may;

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/
 */
public class NumberComplement {
    public static void main(String[] args) {

        System.out.println(new NumberComplement().findComplement(1));
    }

    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        char[] chars = binary.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chars[i] == '1' ? '0' : '1';
        }
        return Integer.parseInt(String.valueOf(chars), 2);
    }
}
