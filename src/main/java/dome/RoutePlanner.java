package dome;

import java.util.*;

public class RoutePlanner {

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {

        boolean ans = false;

        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        boolean[][] visited = new boolean[mapMatrix.length][mapMatrix[0].length];

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(fromRow, fromColumn));
        Point next;
        visited[fromRow][fromColumn] = true;
        while (!q.isEmpty()) {
            Point current = q.remove();

            if (current.r == toRow && current.c == toColumn) {
                return true;
            }

            for (int[] dir : dirs) {
                next = new Point(current.r + dir[0], current.c + dir[1]);
                if (isSafe(next, mapMatrix) && !visited[next.r][next.c]) {
                    q.add(next);
                    visited[next.r][next.c] = true;
                }
            }

        }


        return ans;
    }

    public static boolean isSafe(Point p, boolean[][] mapMatrix) {
        int n = mapMatrix.length;
        int m = mapMatrix[0].length;
        return (p.r >= 0 && p.r < n && p.c >= 0 && p.c < m && mapMatrix[p.r][p.c]);
    }


    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true, false, false},
                {true, true, false},
                {false, true, true}
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }


    public static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
