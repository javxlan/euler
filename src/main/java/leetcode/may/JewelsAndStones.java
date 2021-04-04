package leetcode.may;

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/
 */
public class JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(new JewelsAndStones().numJewelsInStones("aA", "aAAbbbb"));
    }

    public int numJewelsInStones(String J, String S) {

        char[] jewels = J.toCharArray();

        int total = 0;

        for (char j : jewels) {
            int i = S.indexOf(j);
            while (i >= 0) {
                S = S.substring(0, i) + S.substring(i + 1, S.length());
                total++;
                i = S.indexOf(j);
            }
        }

        return total;
    }


}
