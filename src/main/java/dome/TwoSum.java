package dome;

import java.util.*;

public class TwoSum {

    public static int[] findTwoSum(int[] list, int sum) {
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            if (nums.keySet().contains(list[i])) {
                return new int[]{i, nums.get(list[i])};
            }
            nums.put(sum - list[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[]{3, 1, 5, 7, 5, 9}, 11);
        if (indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
