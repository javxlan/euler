package test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class Orange {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        Orange o = new Orange();
        // 2 dimension array initializing
        int[][] grid = {
                {1, 1, 2, 2},
                {0, 1, 1, 2},
                {0, 1, 0, 0},
                {1, 1, 1, 1},
        };
        System.out.println("max level = " + o.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        // get length of rows , get length of first row
        int R = grid.length, C = grid[0].length;

        // queue : all starting cells with rotten oranges
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();

        // finding nodes are for first level of bfs
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                // if cell is rotten
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    // 0 means root of graph
                    depth.put(code, 0);
                    //System.out.println(depth);
                }
        int ans = 0;
        //diving into bfs
        while (!queue.isEmpty()) {
            //System.out.println("queue = " + queue);
            // removing visited node
            int code = queue.remove();
            int r = code / C, c = code % C;
            // looping adjacent nodes
            for (int k = 0; k < 4; ++k) {

                int nr = r + dr[k];
                int nc = c + dc[k];
                System.out.println("grid "+nr + "/" + nc);
                //checking index's of each adjacent cell between in array index max and min limit and adjacent value check is fresh orange
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {

                    //rotting adjacent oranges
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;

                    // adding adjacent node into queue
                    queue.add(ncode);
                    //putting each nodes index with depth
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                    //System.out.println(depth);
                }
            }
        }
        // bfs is done then after check if exist isolated node.
        for (int[] row : grid)
            for (int v : row)
                if (v == 1)
                    return -1;
        return ans;

    }
}
