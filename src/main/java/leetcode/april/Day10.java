package leetcode.april;

import javax.management.StandardEmitterMBean;

public class Day10 {

    class MinStack {

        /**
         * initialize your data structure here.
         */

        Node root = new Node(null);

        public MinStack() {
        }

        public void push(int x) {
            Node newNode = new Node(null);
            newNode.val = x;
            if (root.next == null) {
                root.next = newNode;
                root.next.min = x;
            } else {
                Node temp = root.next;
                newNode.next = temp;
                newNode.min = Math.min(x, root.next.min);
                root.next = newNode;
            }

        }

        public void pop() {
            if (root.next != null) {
                Node temp = root.next;
                root.next = temp.next;
            }
        }

        public int top() {
            return root.next.val;
        }

        public int getMin() {
            return root.next.min;
        }
    }

    public class Node {
        int val;
        Node next;
        int min;

        public Node(Node next) {
            this.next = next;
        }
    }
}


/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * Example
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

