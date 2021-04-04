package test;

import java.util.*;

public class BtreeLeverOrderTraversal {

    public static void main(String[] args) {

        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(9);
        tree1.right = new TreeNode(20);
        tree1.right.right = new TreeNode(7);
        tree1.right.left = new TreeNode(15);

        BtreeLeverOrderTraversal b = new BtreeLeverOrderTraversal();

        System.out.println(b.levelOrderBottom(tree1));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //Queue<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        bfs(root, 0, lists);
        Collections.reverse(lists);
        return lists;
    }


    public void bfs(TreeNode node, int level, List<List<Integer>> lists) {


        // Null pointers don't contribute to the counts.
        if(node == null) {
            return;
        }

        // Keeps track of all nodes in the current level.
        List<Integer> listOfCurrentLevel = null;

        if(lists.size() == level) {
            // Make a new list for this level.
            listOfCurrentLevel = new ArrayList<Integer>();
            lists.add(listOfCurrentLevel);
        }
        else {
            // We have seen this level before.
            listOfCurrentLevel = lists.get(level);
        }

        // Add the current node for this level.
        listOfCurrentLevel.add(node.val);

        bfs(node.left, level+1, lists);
        bfs(node.right, level+1, lists);

    }


}
