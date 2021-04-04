package hackerrank;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 1, 2, 4, 5, 8, 9};

        int n = arr.length;
        //System.out.println(Arrays.toString(getSubKMax(arr, 3)));
        Stack<Integer> stack = new Stack<>();
        int[] leff = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n + 1];


        for (int i = 0; i < n; i++) {
            leff[i] = -1;
            right[i] = n;
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();

            if (!stack.isEmpty()) leff[i] = stack.peek();
            stack.push(i);
        }
    }


    public static int[] getSubKMax(int[] arr, int k) {
        int[] answer = new int[arr.length - k + 1];
        Deque<Integer> window = new ArrayDeque<>(k);

        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                while (!window.isEmpty() && arr[i] >= arr[window.peekLast()]) window.removeLast();
            } else {
                answer[i - k] = arr[window.peek()];
                while (!window.isEmpty() && window.peek() <= i - k) window.removeFirst();
                while (!window.isEmpty() && arr[i] >= arr[window.peekLast()]) window.removeLast();
            }
            window.addLast(i);
        }
        answer[answer.length - 1] = arr[window.peek()];
        return answer;
    }




}
