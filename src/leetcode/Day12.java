package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day12 {

    public static void main(String[] args) {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};

        System.out.println(new Day12().lastStoneWeight(stones));
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
 * Last Stone Weight
 * We have a collection of stones, each stone has a positive integer weight.
 * <p>
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 * <p>
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 * <p>
 * Example 1:
 * <p>
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */

