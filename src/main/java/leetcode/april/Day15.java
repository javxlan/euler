package leetcode.april;

import java.util.Arrays;

public class Day15 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(new Day15().productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int product = 1;
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }
}

/**
 * Product of Array Except Self
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i]..
 */