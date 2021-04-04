package hackerrank;

import java.io.*;
import java.math.*;
import java.net.URL;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the riddle function below.
    static long[] a;

    static long[] riddle(long[] arr) {
        a = arr;
        int n = a.length;
        long[] ans = new long[n];
        long[][] dp = new long[n][n];
        // length
        for (int i = 0; i < n; i++) {
            long max = Long.MIN_VALUE;
            for (int j = 0; j + i < n; j++) {
                long min = a[j + i];
                if (i == 0) {
                    min = getMin(j, j + i);
                } else {
                    min = Math.min(min, dp[i - 1][j + i - 1]);
                }
                dp[i][j + i] = min;
                max = Math.max(max, min);
            }
            ans[i] = max;
        }
        return ans;
    }

    static long getMin(int s, int e) {
        long min = Long.MAX_VALUE;
        while (s <= e) {
            min = Math.min(min, a[s]);
            s++;
        }
        return min;
    }


    public static int minKnightMoves(int x, int y) {

        int count = 0;
        if (x == 0 && y == 0) return count;

        List<Point> dirs = new ArrayList<>();
        dirs.add(new Point(1, -2, 0));
        dirs.add(new Point(2, -1, 0));
        dirs.add(new Point(2, 1, 0));
        dirs.add(new Point(1, 2, 0));
        dirs.add(new Point(-1, 2, 0));
        dirs.add(new Point(-2, 1, 0));
        dirs.add(new Point(-2, -1, 0));
        dirs.add(new Point(-1, -2, 0));

        Queue<Point> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        x = Math.abs(x);
        y = Math.abs(y);

        Point start = new Point(0, 0, 0);
        q.add(start);

        while (!q.isEmpty()) {
            Point current = q.remove();
            for (Point dir : dirs) {
                Point next = new Point(current.x + dir.x, current.y + dir.y, current.step + 1);
                if (next.x < -2 || y < -2) continue;
                if (!visited.contains(next.x + "/" + next.y)) {
                    if (next.x == x && next.y == y) {
                        return next.step;
                    } else {
                        q.add(next);
                        visited.add(next.x + "/" + next.y);
                    }
                }
            }
        }

        return count;
    }

    public static int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // we will iterate over cell with not visited lans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // run bfs
                    queue.clear();
                    int[] temp = new int[]{i, j};
                    queue.add(temp);
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.remove();

                        for (int[] dir : dirs) {
                            // if inside
                            int[] next = new int[]{cur[0] + dir[0], cur[1] + dir[1]};

                            if (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n && grid[next[0]][next[1]] != '0' && !visited[next[0]][next[1]]) {
                                queue.add(next);
                                visited[next[0]][next[1]] = true;
                            }
                        }
                    }
                    ans++;
                }
            }
        }
        return ans;
    }

    public String decodeString2(String s) {
        if (s == null || s.equals("")) return "";
        Stack<Integer> number = new Stack<>();
        Stack<Character> brackets = new Stack<>();
        Stack<String> text = new Stack<>();
        String ans = "";
        char[] str = s.toCharArray();
        String last = "";
        for (char c : str) {
            //if(c=='[')

        }
        return ans.toString();
    }


    public String decodeString(String s) {
        if (s == null || s.equals("")) return "";
        Stack<Integer> number = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int index = 0;
        char[] str = s.toCharArray();
        while (index < str.length) {
            char c = str[index];
            if (Character.isDigit(c)) {
                int count = 0;
                while (Character.isDigit(c)) {
                    count = count * 10 + Character.getNumericValue(c);
                    index += 1;
                    c = str[index];
                }
                number.push(count);
            } else if (c == '[') {
                result.push(res);
                res = "";
                index += 1;
            } else if (c == ']') {
                int num = number.pop();
                String lastStr = result.pop();
                for (int i = 0; i < num; i++) {
                    lastStr += res;
                }
                res = lastStr;
                index += 1;
            } else {
                res += c;
                index += 1;
            }
        }
        return res;
    }


    public void preOrder(char[] str, int i, String s) {
        if (i == str.length) return;
        s += str[i];
        i++;
        preOrder(str, i, s);
    }


    public static void main(String[] args) throws Exception {
        //a = new long[]{"sdfs"};
//        int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
//        int k = 2;
//
//        System.out.println(kMessedArray(arr, k));

        System.out.println(root(8,2));


        //System.out.println(new Solution().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));

        //System.out.println(minKnightMoves(0,300));
//        char[][] grid = new char[][]{
//                {'1', '1', '0', '1', '0'},
//                {'1', '0', '0', '1', '0'},
//                {'0', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };
//        System.out.println(numIslands(grid));

//        int[] nums = new int[]{5,4,3,2,1};
//
//        int[] ans = new int[nums.length];
//        int j;
//        Arrays.fill(ans, -1);
//
//        for (int i = 0; i < nums.length; i++) {
//            if (i == nums.length - 1) j = 0;
//            else j = i + 1;
//            for (; j != i; j++) {
//                // when reached array of end it start from beginning
//                if (j == nums.length ) j = 0;
//                if(i==j) break;
//                if (nums[i] < nums[j]) {
//                    ans[i] = nums[j];
//                    break;
//                }
//            }
//        }
    }

    public static int[] kMessedArray(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int min;
        for (int i = 0; i < arr.length + k; i++) {
            if (i < arr.length) {
                minHeap.add(arr[i]);
                if (minHeap.size() > k) {
                    min = minHeap.remove();
                    arr[i - k] = min;
                }
            } else {
                min = minHeap.remove();
                arr[i - k] = min;
            }
        }
        // k=2
        // arr  :  1, 4, 5, 2, 3, 7, 8, 6, 10, 9
        // index:  0  1  2  3  4  5  6  7  8  9
        // heap :                       10  9
        // final:  1  2  3  4  5  6  7  8

        return arr;
    }

    public static class Point {
        int x, y, step;

        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

    }

    /**
     * written in java
     */

    public static boolean isPrimeHappy(int n) {
        // validate inputs
        if (n <= 2) return false;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) sum += i;
        }

        return sum % n == 0;
    }

    public static boolean isPrime(int n) {
        if (n == 2) return true;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }


    static double root(double x, int n) {

        double left = 0 ;
        double right = x;
        double target = x;

        double mid = (left + right)/2;

        while(left<right) {
            mid = (left + right)/2;
            double multi =multiple(mid,n);
            if(Math.abs(multi-x)<=0.001) return mid;
            if(multi>x) right = mid;
            else left = mid;
        }
        return mid;
    }

    public static double multiple(double x, int n){
        for(int i=2;i<=n;i++){
            x*=x;
        }
        return x;
    }
}

