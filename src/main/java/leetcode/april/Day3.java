package leetcode.april;

public class Day3 {
    public static void main(String[] args) {
        int[] dummy = new int[]{-1};
        System.out.println(new Day3().maxSubArray(dummy));
    }

    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int maxSoFar = Integer.MIN_VALUE, maxTemp = 0;

        for (int i = 0; i < size; i++) {
            maxTemp = maxTemp + nums[i];
            if (maxSoFar < maxTemp) maxSoFar = maxTemp;
            if (maxTemp < 0) maxTemp = 0;
        }

        return maxSoFar;
    }
}

/***
 *
 * Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */


