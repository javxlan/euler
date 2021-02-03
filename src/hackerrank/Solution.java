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


    public static void main(String[] args) throws Exception {
        //a = new long[]{"sdfs"};
        URL url = new URL("https://hr-testcases-us-east-1.s3.amazonaws.com/70881/input04.txt?AWSAccessKeyId=AKIAR6O7GJNX5DNFO3PV&Expires=1612375988&Signature=zbwVl2A21WtNEFB3%2BFbFeyivqpg%3D&response-content-type=text%2Fplain");
        BufferedReader read = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String i;
        int line = 0;
        while ((i = read.readLine()) != null) {

            if (line == 0) {
                a = new long[Integer.parseInt(i)];
            } else {
//                a = Arrays.stream(i.split(" "))
//                        .mapToLong(Long::parseLong)
//                        .toArray();
            }
            line++;
        }
        read.close();

        System.out.println(Arrays.toString(riddle(a)));
    }
}

