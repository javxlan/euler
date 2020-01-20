package test;

public class Problem1 {
    public static void main(String[] args) {
        int sum = 0, x = 3, y = 5, limit = 1000;

        for (int i = x; i < limit; i += x) {
            if (i % y != 0) {
                sum += i;
            }
        }

        for (int i = y; i < limit; i += y) {
            sum += i;
        }

        System.out.println(sum);

    }
}
