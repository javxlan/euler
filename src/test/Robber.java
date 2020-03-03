package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Robber {

    public static void main(String[] args) {
        Robber r = new Robber();
        int[] houses = new int[]{2, 7, 9, 3, 1};
        System.out.println(r.rob(houses));
    }

    public int rob(int[] nums) {

        if (nums.length == 0 || nums == null) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            System.out.println(dp[i]);
        }

        return dp[dp.length - 1];
    }
}
