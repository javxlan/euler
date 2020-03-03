package test;

import java.util.*;

public class CoupleKnights {

    public static String[] label = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};

    public static void main(String[] args) {

        int[] dr = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
        int[] dc = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};

        Queue<Point> tour = new ArrayDeque<>();
        Map<Point, Integer> depth = new HashMap<>();

        Point startPoint = new Point(7, 0, null);
        Point destination = new Point(0, 6, null);
        Point nextMove;

        int C = 7, R = 7;

        int[][] board = new int[8][8];

        // cleaning the board
        for (int row = R; row >= 0; row--) {
            for (int column = 0; column <= C; column++) {
                board[row][column] = 0;
            }
        }

        //attackers starting point
        board[startPoint.r][startPoint.c] = 1;
        int level = 0;
        depth.put(startPoint, level);

        tour.add(startPoint);
        System.out.println("");
        System.out.println("*******************************************************");
        System.out.println("start point = " + chess(startPoint.r, startPoint.c));
        System.out.println("destination point = " + chess(destination.r, destination.c));

        while (!tour.isEmpty() && (board[destination.r][destination.c] != 2)) {
            Point current = tour.remove();
            for (int m = 0; m < 8; m++) {
                             int nr = current.r + dr[m];
                int nc = current.c + dc[m];


                if (nr >= 0 && nr <= R && nc >= 0 && nc <= C && board[nr][nc] == 0) {
                    // found destination
                    if (destination.r == nr && destination.c == nc) {
                        board[nr][nc] = 2;
                        System.out.println(current.path + " -> " + chess(nr, nc));
                        System.out.println("movement deep = " + (depth.get(current) + 1));
                    } else {
                        // visited
                        board[nr][nc] = 1;
                    }
                    nextMove = new Point(nr, nc, current.path + " -> " + chess(nr, nc));
                    tour.add(nextMove);
                    depth.put(nextMove, depth.get(current) + 1);
                    //System.out.println("depth =" + depth.get(nextMove) + " " + chess(nr, nc));
                }
            }

        }
        System.out.println("*******************************************************");
    }

    public static String chess(int r, int c) {
        return label[c] + (r + 1);
    }


    private static class Point {
        int r, c;

        String path;

        Point(int r, int c, String path) {
            this.r = r;
            this.c = c;
            this.path = path != null ? path : chess(r, c);
        }
    }


}
