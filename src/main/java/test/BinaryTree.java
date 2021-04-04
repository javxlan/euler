package test;

public class BinaryTree {

    Node root;

    public void addNode(int key, String name) {

        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void testTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            testTraverseTree(focusNode.leftChild);
            testTraverseTree(focusNode.rightChild);
        }
    }

    public static void main(String[] args) {
        BinaryTree tTree = new BinaryTree();
        tTree.addNode(14, "14");
        tTree.addNode(16, "16");
        tTree.addNode(41, "41");
        tTree.addNode(16, "16");
        tTree.addNode(16, "16");
        tTree.addNode(16, "16");

        tTree.inOrderTraverseTree(tTree.root);
    }
}


class Node {
    int key;
    String name;
    Node leftChild;
    Node rightChild;

    Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return this.name + "has a key " + this.key;
    }

}