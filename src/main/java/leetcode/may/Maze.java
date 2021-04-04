package leetcode.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Maze {
    boolean[][] visited;
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][] board = {
            {1, 1, 0, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 1, 1},
            {1, 1, 0, 0, 1}};
    int[] target = {3, 4};

    public static void main(String[] args) {

        int[] start = {0, 0};

        Maze m = new Maze();
        m.visited = new boolean[m.board.length][m.board[0].length];

        //System.out.println(m.getMap(m.board, start, target));
        m.dfs(m.getAdj(start));
    }

    public List<int[]> getAdj(int[] curr) {
        List<int[]> temp = new ArrayList<>();
        for (int[] dir : directions) {
            int[] next = {curr[0] + dir[0], curr[1] + dir[1]};
            if (isSafe(next[0], next[1])) {
                temp.add(next);
            }
        }
        return temp;
    }

    public void dfs(List<int[]> adjs) {
        for (int[] adj : adjs) {
            if (!visited[adj[0]][adj[1]]) {
                System.out.println(Arrays.toString(adj));
                visited[adj[0]][adj[1]] = true;
                if (target[0] == adj[0] && target[1] == adj[1]) {
                    return;
                } else {
                    List<int[]> list = getAdj(adj);
                    dfs(list);
                }
            }
        }
    }

    public List<int[]> getMap(int[] start, int[] target) {

        List<int[]> path = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        boolean[][] visited = new boolean[board.length][board[0].length];
        stack.add(start);
        //visited[start[0]][start[1]] = true;
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            if (!visited[current[0]][current[1]]) {
                visited[current[0]][current[1]] = true;

                if (current[0] == target[0] && current[1] == target[1]) break;
                for (int[] dir : directions) {
                    int[] next = {current[0] + dir[0], current[1] + dir[1]};
                    // safe and not visited
                    if (isSafe(next[0], next[1]) && !visited[next[0]][next[1]]) {
                        stack.add(next);
                        System.out.println(next[0] + "," + next[1]);
                    }
                }
            }
        }
        for (int[] st : stack) {
            System.out.println(Arrays.toString(st));
            path.add(st);
        }

        return path;
    }

    public boolean isSafe(int r, int c) {
        return (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 1);
    }
}
