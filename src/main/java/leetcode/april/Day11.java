package leetcode.april;

public class Day11 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null) return getDepthOfTree(root.right, 0);
        if (root.right == null) return getDepthOfTree(root.left, 0);

        return getDepthOfTree(root.left, 0) + getDepthOfTree(root.right, 0);
    }


    public int getDepthOfTree(TreeNode node, int depth) {

        if (node.left != null) getDepthOfTree(node.left, depth + 1);
        if (node.right != null) getDepthOfTree(node.right, depth + 1    );

        return depth;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}