package leetcode.may;

import java.util.*;

public class Find2Sum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 5, 15, 3, 12};
        int target = 19;
        System.out.println(threeSum(arr, target).toString());
    }


    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums.length < 3) return ans;

        Set<String> triplets = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            temp = twoSum(nums, target - nums[i], i + 1);
            for (List<Integer> ls : temp) {
                ls.add(nums[i]);
                if (!triplets.contains(ls.toString())) {
                    ans.add(ls);
                    triplets.add(ls.toString());
                }
            }
        }

        return ans;
    }


    public static List<List<Integer>> twoSum(int[] arr, int target, int left) {
        List<List<Integer>> ans = new ArrayList<>();
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[left]);
                temp.add(arr[right]);
                ans.add(temp);
            }
            if (sum < target) left++;
            else right--;
        }
        return ans;
    }
}
