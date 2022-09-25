package InsertSortedCircularLinkedList;


// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }




class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head.val = insertVal;
            head.next = null;
            return head;
        }
        if (head.next == null) {
            Node cur = head;
            Node tail = null;
            cur.next = tail;
            tail.val = insertVal;
            tail.next = null;
            return head;
        }

        Node cur = head;
        Node prev = null;
        Node nextNode=null;
        cur.next = nextNode;
        //Conner Case
        //find the location of max value in a linkedList
        Node MaxNode = head;
        int max = MaxNode.val;
        int i;
        for (i = 0; max <= MaxNode.next.val; i++) {
            max = MaxNode.val;

            MaxNode = MaxNode.next;
        }//right now MaxNode located at  ListNode which has maxval
        Node MinNode = MaxNode.next;
        int min = MaxNode.next.val;

        Node insert = null;
        insert.val = insertVal;
        Node MediumNode = MinNode;


        if (insertVal >= max && insertVal <= min) {
            MaxNode.next = insert;
            insert.next = MinNode;
            return head;
        } else {
            while (MediumNode.val < insertVal) {

                prev = MediumNode;
                MediumNode = MediumNode.next;

            }
            Node Next = MediumNode.next;
            prev.next = insert;
            insert.next = next;
            return head;
        }

    }
}
    }

    // 1st find a location which this location's val less than insertVal and this nextNode.val large is also less insertVal





