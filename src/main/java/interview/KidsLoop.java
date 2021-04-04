package interview;

import java.util.*;

/**
 * @author Javkhlan Gansukh
 * <p>
 * Coding approach .
 * Problem is find all possible area. Not longest,shortest or unique path,
 * So it means we can use on it the Breadth-first search algorithm.
 * see details in here https://en.wikipedia.org/wiki/Breadth-first_search
 * Our grid transform to graph and starting point is root of the graph.
 * root's neighbors are children of root and it explore to all possible nodes.
 * the grid can be infinity but we have some threshold.
 * So we have to check this threshold and won't move back to root of the certain node
 * In order to avoid duplicate visitation, we have to keep the visited nodes.
 * <p>
 * pseudocode
 * define 4 directions.
 * starting point add to queue. It works FIFO.
 * while(queue)
 * get and remove first element from the queue and set it to current point
 * increment visited nodes.
 * if children nodes safe and not visited then it will be added on queue
 * end of while all nodes are explored and answer should be size visited nodes
 * <p>
 * Time complexity: O(N)
 */
public class KidsLoop {
    public int threshold = 23;
    Point[] directions;
    Map<String, Point> visited;

    public static void main(String[] args) {
        KidsLoop assignment = new KidsLoop();
        int answer = assignment.solve();
        System.out.println(answer);
    }

    public KidsLoop() {
        // initializing variables in constructor
        visited = new HashMap<>();
        directions = new Point[4];
        directions[0] = new Point(1, 0); // x+1,y
        directions[1] = new Point(-1, 0); // x-1,y
        directions[2] = new Point(0, 1); // x,y+1
        directions[3] = new Point(0, -1); // x,y-1
    }

    public int solve() {
        // initiating the starting point, it's from (0,0)
        Point startPoint = new Point(0, 0);
        // checking corner case. for example if threshold -1 answer must be 0.
        if (isSafe(startPoint)) {
            visited.put(String.valueOf(startPoint.x) + "," + String.valueOf(startPoint.y), startPoint);
            moveRobot(startPoint);
        }
        return visited.size();
    }

    public void moveRobot(Point p) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(p);
        Point nextPoint, current;
        while (!queue.isEmpty()) {
            // getting first
            current = queue.remove();
            for (Point dir : directions) {
                nextPoint = new Point(current.x + dir.x, current.y + dir.y);
                //the robot moves to the next point when the next point is not visited and safe
                if (isSafe(nextPoint) && !isVisited(nextPoint)) {
                    // once removed on it, now should be add
                    queue.add(nextPoint);
                    visited.put(String.valueOf(nextPoint.x) + "," + String.valueOf(nextPoint.y), nextPoint);
                }
            }
        }
    }

    public boolean isVisited(Point p) {
        return visited.getOrDefault((String.valueOf(p.x) + "," + String.valueOf(p.y)), null) == null ? false : true;
    }

    public boolean isSafe(Point p) {
        int isSafe = digitSum(p.x) + digitSum(p.y);
        if (isSafe <= threshold) return true;
        else return false;
    }

    public int digitSum(int n) {
        int sum = 0;
        n = Math.abs(n);
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}