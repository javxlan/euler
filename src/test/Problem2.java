package test;

public class Problem2 {
    public static void main(String[] args) {

        int sum = 0, y = 1, limit = 4000000;

        for (int i = 1; i < limit; i += y, y = i - y) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
