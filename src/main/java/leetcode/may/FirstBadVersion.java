package leetcode.may;

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(100));
    }

    public int firstBadVersion(int n) {
        return findBadVersion(0, n, n / 2);
    }

    public int findBadVersion(int left, int right, int middle) {

        if ((right - left) == 2) middle = left + 1;
        if (isBadVersion(middle) && !isBadVersion(middle - 1)) return middle;

        System.out.println(left + "," + right + "," + middle);

        if (isBadVersion(middle)) {
            return findBadVersion(left, middle, (left + (right - left) / 4));
        } else {
            return findBadVersion(middle, right, (right - (right - left) / 4));
        }
    }

    private boolean isBadVersion(int i) {
        return i >= 27;
    }
}
