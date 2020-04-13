package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day13 {

    public static void main(String[] args) {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};

        System.out.println(new Day13().lastStoneWeight(stones));
    }


    public int lastStoneWeight(int[] stones) {

        Arrays.sort(stones);
        int size = stones.length;
        if (size == 0) return 0;
        if (size == 1) return stones[0];

        int y = stones[size - 1];
        int x = stones[size - 2];

        stones[size - 1] = y - x;
        stones[size - 2] = x - x;

        return lastStoneWeight(updateStone(stones));
    }

    public int[] updateStone(int[] arr) {
        List<Integer> updated = new ArrayList<>();
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            if (arr[i] != 0) updated.add(arr[i]);
        }
        return updated.stream().mapToInt(i -> i).toArray();
    }
}

/**
 * Contiguous Array
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */

