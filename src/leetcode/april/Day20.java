package leetcode.april;

public class Day20 {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 5, 1, 7, 10, 12};
        System.out.println(new Day20().bstFromPreorder(arr));
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            root = build(root, preorder[i]);
        }
        return root;
    }


    public TreeNode build(TreeNode node, int val) {
        if (node.val > val) {
            if (node.left != null) build(node.left, val);
            else node.left = new TreeNode(val);
        } else {
            if (node.right != null) build(node.right, val);
            else node.right = new TreeNode(val);
        }
        return node;
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

/**
 * Construct Binary Search Tree from Preorder Traversal
 * <p>
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node,
 * any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first,
 * then traverses node.left, then traverses node.right.)
 */