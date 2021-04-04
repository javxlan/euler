package test;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {


    public static void main(String[] args) {

        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(9);
        tree1.right = new TreeNode(20);
        tree1.right.right = new TreeNode(7);
        tree1.right.left = new TreeNode(15);

        MinDepth b = new MinDepth();

        System.out.println(b.minDepth(tree1));
    }


    public boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null){
            return true;
        }else{
            return false;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(isLeaf(root)) return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(isLeaf(node)) return level;
                if(node.left!= null) queue.add(node.left);
                if(node.right!= null) queue.add(node.right);
            }
            level++;
        }
        return level;
    }
}
