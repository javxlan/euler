// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
package test;

import java.util.List;
import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Servers {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED


    public static void main(String[] arg) {

        Servers s = new Servers();
        List<List<Integer>> grid = new ArrayList<List<Integer>>();
        grid.add(Arrays.asList(0, 0, 0, 0, 0));
        grid.add(Arrays.asList(0, 0, 0, 0, 0));
        grid.add(Arrays.asList(0, 0, 1, 0, 0));
        grid.add(Arrays.asList(0, 0, 0, 0, 0));
        grid.add(Arrays.asList(0, 0, 0, 0, 0));

        //int[][] grid = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        s.printGrid(grid, 0);
        System.out.println(s.minimumDays(5, 5, grid));
    }

    private static final int[][] ADJACENT = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int minimumDays(int rows, int columns, List<List<Integer>> grid) {
        int outDatedServers = 0;
        Queue<Point> updatedServers = new ArrayDeque<>();
        for (int r = 0; r < grid.size(); r++) {
            for (int c = 0; c < grid.get(0).size(); c++) {
                if (grid.get(r).get(c) == 1) {
                    updatedServers.add(new Point(r, c));
                } else {
                    outDatedServers++;
                }
            }
        }

        if (outDatedServers == 0) return 0;

        for (int days = 1; !updatedServers.isEmpty(); days++) {
            for (int sz = updatedServers.size(); sz > 0; sz--) {
                Point server = updatedServers.poll();

                for (int[] ad : ADJACENT) {
                    int r = server.r + ad[0];
                    int c = server.c + ad[1];

                    if (isOutOfDated(grid, r, c)) {
                        outDatedServers--;
                        if (outDatedServers == 0) return days;
                        grid.get(r).set(c, 1);
                        updatedServers.add(new Point(r, c));
                    }
                }
            }
            printGrid(grid, days);
        }
        return -1;

    }

    public void printGrid(List<List<Integer>> grid, int day) {
        System.out.println("day=" + day);
        grid.forEach(list -> System.out.println(list));
    }

    private boolean isOutOfDated(List<List<Integer>> grid, int r, int c) {
        return r >= 0 && r < grid.size() && c >= 0 && c < grid.get(0).size() && grid.get(r).get(c) != 1;
    }

    private static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // METHOD SIGNATURE ENDS
}