package dome;

import java.util.*;

/**
 * In an effort to connect all airports with minimal costs, an airport authority needs to
 * identify the minimum number of new flight connections so that it is possible to reach all airports from
 * every other airport directly or indirectly. Airports and flight connections are represented by a matrix.
 * Airports are represented by numbers 0, 1, 2, and so on. So, if airport 'O' is connected via a flight with airport '1'
 * then elements [O][1] and [1][0] will have the value True, or False if there is no flight connectivity.
 * All flights are bi-directional. The function get_minimum_connections accepts a two-dimensional array matrix.
 * The function should return the minimum number of flight connections that need to be added so that
 * all airports are reachable from every other airport, directly or indirectly. For example,
 * the following code should print 1, as a minimum of 1 0 1 additional flight connection will connect all airports
 * (directly or indirectly). 2. 3 4
 * matrix = 1 [
 * [False, True, False, False, True),
 * [True, False, False, False, False),
 * [False, False, False, True, False},
 * [False, False, True, False, False),
 * [True, False, False, False, False] ]
 * print(get_minimum_connections (matrix))
 */


public class ConnectedComponentCount {
    //private int v;
    private int e;
    private Map<Integer, HashSet<Integer>> adjMap;
    private static Map<Integer, Integer> visited;

    // Function to add edges
    private void addEdge(int s, int d) {
        adjMap.putIfAbsent(s, new HashSet<Integer>());
        adjMap.putIfAbsent(d, new HashSet<Integer>());
        adjMap.get(s).add(d);
        adjMap.get(s).add(s);
        adjMap.get(d).add(s);
        adjMap.get(d).add(d);
        visited.put(s, 0);
        visited.put(d, 0);
    }

    // To mark vertices which can be visites
    private void findDFS(int vertex) {

        visited.put(vertex, 1);
        for (Integer child : adjMap.get(vertex)) {
            if (visited.get(child) == 0) {
                findDFS(child);
            }
        }
    }

    public int getMinConnections(boolean[][] matrix) {
        int ccCount = 0;
        int vertices = matrix.length;

        adjMap = new HashMap<Integer, HashSet<Integer>>();
        visited = new HashMap<Integer, Integer>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] && i <= j) {
                    addEdge(i, j);
                }
            }
        }

        for (Integer vertex : visited.keySet()) {
            if (visited.get(vertex) == 0) {
                // Function Call for findDFS
                findDFS(vertex);
                // Increase the counter
                ccCount++;
            }
        }

        int unVisited = vertices - visited.size();

        return (ccCount + unVisited - 1);
    }

    // Driver Code
    public static void main(String args[]) {

        boolean[][] matrix = {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };

        System.out.println("needed line: " + new ConnectedComponentCount().getMinConnections(matrix));
    }
}
