package hackerrank;


import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int n = s.nextInt();
            int x = n;
            int y = (n & (n - 1));
            System.out.println(x & y);
        }
    }
}
