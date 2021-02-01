package leetcode.august;

import java.util.ArrayDeque;
import java.util.Queue;

public class KnightDialer {

        int count;
        int[][] pad = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {-1,0,-1}
        };

        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        System.out.println(new KnightDialer().knightDialer(10));
    }

        public int knightDialer(int n) {
            count = 0;
            for(int i=0;i<4;i++)
                for(int j=0;j<3;j++)
                    if(isSafe(i,j)) moveKnight(i,j,n);
            return count;
        }

        public void moveKnight(int i, int j, int n){
            Queue<Point> q = new ArrayDeque<>();

            q.add(new Point(i,j,1));
            int k, next_x, next_y;
            int[] mem = new int[10];

            while (!q.isEmpty()) {
                Point current = q.remove();

                if(current.step<n){

                    for (k = 0; k < 8; k++) {
                        next_x = current.j + xMove[k];
                        next_y = current.i + yMove[k];
                        if (isSafe(next_x, next_y)) {
                            q.add(new Point(next_x,next_y,current.step+1));
                        }
                    }
                }else{
                    // System.out.println("i = "+current.i+", j={"+current.j+"} step = {"+current.step+"}");
                    mem[pad[current.i][current.j]]=n;
                    count++;
                }
            }

        }


        public boolean isSafe(int i, int j){
            if(i>=0&&i<=3&& j>=0&&j<=2 && pad[i][j]!=-1) return true;
            else  return false;
        }

        public class Point{
            int i,j,step;
            public Point(int i, int j, int step){
                this.i=i;
                this.j=j;
                this.step=step;
            }
        }



}
