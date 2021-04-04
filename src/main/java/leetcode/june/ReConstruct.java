package leetcode.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReConstruct {

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        reconstructQueue(people);

    }

    public static int[][] reconstructQueue(int[][] people) {

        List<int[]> result = new ArrayList<>();
        System.out.println("********* unsorted queue ***********");
        System.out.println(Arrays.deepToString(people));

        Arrays.sort(people, (a, b) -> {
            return (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        });
        System.out.println("*********** sorted DESC a[0], ASC a[1] ***********");
        System.out.println(Arrays.deepToString(people));

        System.out.println("*********** constructing queue ***********");
        for (int[] x : people) {
            result.add(x[1], x);
            System.out.println(Arrays.deepToString(result.toArray()));
        }

        return result.toArray(new int[people.length][2]);
    }
}
