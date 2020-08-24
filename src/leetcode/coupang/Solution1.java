package leetcode.coupang;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {


        int[][] location = new int[][]{{0, 3}, {1, 1}, {1, 5}, {2, 2}, {3, 3}, {4, 0}};

        int answer = -1;

        int[] s = {3, 4};
        int[] e = {0,0};
        Point tr, lb, lt, rb;

        //right
        if (s[0] < e[0]) {

            // up
            if (s[1] < e[1]) {
                lb = new Point(s[0], s[1]);
                tr = new Point(e[0], e[1]);
                lt = new Point(lb.x, tr.y);
                rb = new Point(tr.x, lb.y);
            } else {
                //down
                lt = new Point(s[0], s[1]);
                rb = new Point(e[0], e[1]);
                lb = new Point(lt.x, rb.y);
                tr = new Point(rb.x, lt.y);
            }
        } else {
            // left
            //up
            if (s[1] < e[1]) {
                lt = new Point(e[0], e[1]);
                rb = new Point(s[0], s[1]);
                lb = new Point(lt.x, rb.y);
                tr = new Point(rb.x, lt.y);
            } else {
                //down

                tr = new Point(s[0], s[1]);
                lb = new Point(e[0], e[1]);
                rb = new Point(tr.x, lb.y);
                lt = new Point(lb.x, tr.y);
            }
        }

        // loop through points
        for (int[] point : location) {

            Point p = new Point(point[0], point[1]);
            // check the point whether inside or not
            if (p.getX() >= lb.getX() && p.getX() <= rb.getX() &&
                    p.getY() >= lb.getY() && p.getY() <= lt.getY()) {
                answer++;
            }
        }


        if(answer!=-1) answer++;

        System.out.println(answer);
    }

    public static class Point {
        int x, y;


        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }


}
