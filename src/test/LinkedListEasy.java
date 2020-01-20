package test;

public class LinkedListEasy {

    public static void main(String[] args) {

        LinkedListEasy l = new LinkedListEasy();


        ListNode n = new ListNode(2);
        n.next = new ListNode(5);
        n.next.next = new ListNode(10);
        n.next.next.next = new ListNode(20);
        n.next.next.next.next = new ListNode(15);

        print(l.middleNode(n));;
    }

    // print a linked list

    public static void print(ListNode list)
    {
        while (list != null) {
            System.out.print(list.val+" ");
            list = list.next;
        }
        System.out.println();
    }

    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head.next != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
