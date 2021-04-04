package test;

import java.util.ArrayList;
import java.util.List;

public class PhoneScreen {
    public static void main(String[] args) {

        TreeNode tree1 = new TreeNode(5);
        tree1.left = new TreeNode(3);
        tree1.left.left = new TreeNode(1);
        tree1.right = new TreeNode(5);
        tree1.right.left = new TreeNode(6);


        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(6);
        tree2.right.left = new TreeNode(5);
        tree2.right.right = new TreeNode(5);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(tree1,list1);
        inorder(tree2,list2);


        System.out.println(list1.equals(list2));
    }

    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

}

