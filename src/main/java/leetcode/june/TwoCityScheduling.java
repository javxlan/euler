package leetcode.june;

import java.util.Arrays;

public class TwoCityScheduling {

    public static void main(String[] args) {
        int[][] costs = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        twoCitySchedCost(costs);
    }

    public static int twoCitySchedCost(int[][] costs) {
        int min = 0, N = costs.length / 2;
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]);
        });

        Arrays.asList(costs).forEach(cost -> {
            System.out.println(cost[0]+","+cost[1]);
        });

        for (int i = 0; i < N; i++)
            min += costs[i][0];
        for (int i = N; i < 2 * N; i++)
            min += costs[i][1];
        //System.out.println(min);
        return min;
    }
}
