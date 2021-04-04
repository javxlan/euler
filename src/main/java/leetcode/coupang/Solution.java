package leetcode.coupang;

import java.util.*;

public class Solution {
//    public static void main(String[] args) {
//        // [20,8,10,1,4,15]
//        int[] number = new int[]{20, 8, 10, 1, 4, 15};
//        // [10,4,20,1,15,8]
//        // 20,15,10,8,4,1
//
//        // 10 4 20 1 15 8
//        // 19 + 14 + 11+ 6+ 2
//        // 6 16 19 14 7
//        //
//
//        solution(number);
//    }

    static int maxOrder(Integer []a, int n)
    {
        List<Integer> order =
                new ArrayList<Integer>();
        Arrays.sort(a);
        for (int i = 0; i < n / 2; ++i) {
            order.add(a[i]);
            order.add(a[n - i - 1]);
        }
        // If there are odd elements
        if (n % 2 != 0)
            order.add(a[n/2]);

        int answer = 0;

        for (int i = 0; i < n - 1; ++i) {

            answer = answer +
                    Math.abs(order.get(i)
                            - order.get(i + 1));
        }

        // absolute difference of last element
        answer = answer +
                Math.abs(order.get(n - 1)
                        - order.get(0));
        return answer;
    }

    // Driver Code
    public static void main(String args[])
    {
        Integer []a = { 20,8,10,1,4,15 };
        int n = a.length;

        System.out.println(maxOrder(a, n));
    }


}
