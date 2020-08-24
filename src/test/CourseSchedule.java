package test;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] pre = {{0, 1}, {1, 0}};
        int[] result = new CourseSchedule().findOrder(2, pre);
        System.out.println(Arrays.toString(result));
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] result = new int[numCourses];

        // No. of vertices
        int vertices = numCourses;

        // Adjacency List as ArrayList of ArrayList's
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);

        // initializing empty array list by all vertices
        for (int i = 0; i < vertices; ++i)
            adj.add(new ArrayList<Integer>());

        // setting adjacency for prerequisites
        // prerequisites[i][1] ---> dependency of prerequisites[i][0] it means prerequisites[i][1] parent of prerequisites[i][0].
        // adding child vertices of  prerequisites[i][1].
        for (int i = 0; i < prerequisites.length; ++i)
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);

        // Mark all the vertices as not visited
        int[] visited = new int[vertices];
        // detect cycle
        for (int i = 0; i < numCourses; i++) {
            if (!hasCycle(adj, i, visited)) {
                return new int[0];
            }
        }


        Stack<Integer> stack = new Stack<Integer>();


        for (int i = 0; i < vertices; i++)
            visited[i] = 0;

        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < vertices; i++)
            if (visited[i] == 0)
                topologicalSortUtil(i, visited, stack, adj);

        if (stack.size() != numCourses) return new int[0];
        // Print contents of stack
        int i = 0;
        while (stack.empty() == false) {
            result[i] = stack.pop();
            i++;
        }


        return result;
    }


    public void topologicalSortUtil(int v, int[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        // Mark the current node as visited.
        visited[v] = 2;
        Integer i;

        // Recur for all the vertices adjacent
        // to this vertex
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (visited[i] == 0)
                topologicalSortUtil(i, visited, stack, adj);
        }

        // Push current vertex to stack
        // which stores result
        stack.push(new Integer(v));

    }

    private boolean hasCycle(ArrayList<ArrayList<Integer>> adjList, int idx, int[] visited) {
        if (visited[idx] == 2) return true;
        if (visited[idx] == 1) return false;
        visited[idx] = 1;
        List<Integer> neighbours = adjList.get(idx);
        for (int i = 0; i < neighbours.size(); i++) {
            if (visited[neighbours.get(i)] == 2) continue;
            if (visited[neighbours.get(i)] == 1 || !hasCycle(adjList, neighbours.get(i), visited)) {
                return false;
            }
        }
        visited[idx] = 2;
        return true;
    }
}
