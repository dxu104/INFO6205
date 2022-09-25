package RotateList;

//Definite a singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    class RotateList {
        public ListNode rotateRight(ListNode head, int k) {
            //Conner Case
            if (head == null) return null;
            if (head.next == null) return head;
            //the action we rotated a list is pretty like
            // we rotate prayer beads. So we need to form a cycle.
            // first we need to traverse all nodes to get the length of LinkedList
            ListNode tail = head;
            int i;
            for (i = 1; tail.next != null; i++) {
                //move the tail position to next by assign a tail to its next node.
                tail = tail.next;
            }
            //form a cycle
            tail.next = head;
            // find the new tail(i-k%i th node), we consider the head as first.
            ListNode newTail = head;
            //  we let the new tail go to that place.
            for (int j = 1; j < i - k % i; j++) {
                newTail = newTail.next;
            }
            // The newHead should be next node of node newTail
            ListNode newHead = newTail.next;
            //Remember Node newTail still points to newHead
            // Therefore, we need to break their connection.
            newTail.next = null;
            return newHead;
        }
    }
}






