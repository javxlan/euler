package leetcode.may;

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/
 */
public class FirstUniqueCharacterString {

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterString().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        String origin = s, search = null;
        int index = -1;

        while (s.length() > 0) {
            search = s.substring(1, s.length());
            if (search.indexOf(s.substring(0, 1)) >= 0) {
                s = s.replaceAll(String.valueOf(s.substring(0, 1)), "");
            } else {
                index = origin.indexOf(s.substring(0, 1));
                break;
            }
        }
        return index;
    }
}
