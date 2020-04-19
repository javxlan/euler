package leetcode;

import java.awt.*;
import java.util.*;

public class Day18 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new Day18().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {

        Queue<Point> queue = new ArrayDeque<>();

        Point start = new Point(0, 0);
        start.sum += grid[start.row][start.column];
        Point target = new Point(grid.length - 1, grid[0].length - 1);

        ArrayList<Integer> results = new ArrayList<>();
        queue.add(start);
        int min = -1;
        while (!queue.isEmpty()) {
            Point current = queue.remove();
            if (current.row == target.row && current.column == target.column) {
                if (min == -1) {
                    min = current.sum;
                } else {
                    if (min > current.sum) min = current.sum;
                }
            }


            Point right = new Point(current.row, current.column + 1);

            Point down = new Point(current.row + 1, current.column);
            if (isInside(right, grid)) {
                right.sum = grid[right.row][right.column] + current.sum;
                queue.add(right);
            }
            if (isInside(down, grid)) {
                down.sum = grid[down.row][down.column] + current.sum;
                queue.add(down);
            }
        }
        return min;
    }

    public boolean isInside(Point p, int[][] grid) {
        return (p.row >= 0 && p.row < grid.length && p.column >= 0 && p.column < grid[0].length);
    }


    public class Point {
        int row, column;
        int sum = 0;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }


}
/**
 * Minimum Path Sum
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
