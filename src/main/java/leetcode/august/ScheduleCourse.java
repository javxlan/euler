package leetcode.august;

import java.util.LinkedList;

public class ScheduleCourse {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int count = 0;
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }

        System.out.println("in degree: " + inDegree.length);
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }

        System.out.println("stack size: " + stack.size());

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            count++;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == curr) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        stack.push(prerequisites[i][0]);
                    }
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {

        int[][] prerequisites = new int[][]{{0, 1}, {1, 0}};

        System.out.println(new ScheduleCourse().canFinish(2, prerequisites));
    }
}
