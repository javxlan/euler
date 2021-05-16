package soti;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an Unsorted array of repetitive elements. Find the maximum distance between 2 same numbers.
 */
public class FindMaxDistance {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        System.out.println(distance(arr));
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) map.put(arr[i], i);
            else max = Math.max(max, i - map.get(arr[i]));
        }
        return max;
    }

    public static int distance(int[] arr) {
        int size = arr.length;
        for (int dist = size - 1; dist > 0; dist--) {
            // find by distance
            for (int left = 0; left + dist < size; left++) {
                if (arr[left] == arr[left + dist]) {
                    return dist;
                }
            }
        }
        return 0;
    }
}
