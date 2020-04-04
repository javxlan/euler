package leetcode;

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
