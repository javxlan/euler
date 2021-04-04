package dome;

import java.util.Arrays;

public class MCQ {

    public static int[] arrayMystery(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            a[i] = a[i + 1] + a[i - 1];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a1 = {3, 7};
        System.out.println(Arrays.toString(arrayMystery(a1)));
        int[] a2 = {4, 7, 4, 2, 10, 9};
        System.out.println(Arrays.toString(arrayMystery(a2)));

        int[] a3 = {1, 5, 0, 0, 5, 0};
        System.out.println(Arrays.toString(arrayMystery(a3)));

        int[] a4 = {13, 0, -4, -2, 0, -1};
        System.out.println(Arrays.toString(arrayMystery(a4)));

        int[] a5 = {2, 4, 6, 8, 16};
        System.out.println(Arrays.toString(arrayMystery(a5)));
    }
}
