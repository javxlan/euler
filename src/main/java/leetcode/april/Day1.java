package leetcode.april;

import java.util.Arrays;

public class Day1 {

  public static void main(String[] args) {
    int[] nums = new int[] {3, 5, 2, 5, 2};
    Day1 p = new Day1();
    System.out.println(p.singleNumber(nums));
  }

  public int singleNumber(int[] nums) {
    Arrays.sort(nums);
    int result = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (i == nums.length - 1) {
        result = nums[i];
        break;
      }
      if (nums[i] == nums[i + 1]) {
        i++;
      } else {
        result = nums[i];
        break;
      }
    }
    return result;
  }
}

/**
 * *
 *
 * <p>Single Number Given a non-empty array of integers, every element appears twice except for one.
 * Find that single one.
 *
 * <p>Note:
 *
 * <p>Your algorithm should have a linear runtime complexity. Could you implement it without using
 * extra memory?
 *
 * <p>Example 1:
 *
 * <p>Input: [2,2,1] Output: 1 Example 2:
 *
 * <p>Input: [4,1,2,1,2] Output: 4
 */
