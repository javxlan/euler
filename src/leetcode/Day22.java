package leetcode;

public class Day22 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        System.out.println(new Day22().subArraySum(nums, k));
    }

    public int subArraySum(int[] nums, int k) {
        int sum = 0, total = 0;
        int[] dp = new int[nums.length];
        if (nums == null || nums.length == 0) return 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                sum = nums[i];
                total++;
                dp[i] = total;
            }

            dp[i] = Math.max(dp[i], dp[i - 1]);

        }
        return total;
    }
}
