package swapNodes;


//Definition for singly-linked list.
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
}

class swapNodes {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode tail = head;
        int n;
        //get length of the LinkedList.
        for (n = 1; tail.next != null; n++) {
            tail = tail.next;
        }
        //find the location of kth nodes(1-indexed) needed to be swapped.
        ListNode frontCur = head;
        int i;
        for (i = 1; i < k; i++) {
            frontCur = frontCur.next;
        }

        //store the kth node.val
        int frontVal = frontCur.val;
        //find the location of another nodes needed to be swapped
        ListNode endCur = head;
        int j;
        for (j = 1; j < n + 1 - k; j++) {
            endCur = endCur.next;
        }
        //store the second node value.
        int endVal = endCur.val;

        //swap their value
        frontCur.val = endVal;
        endCur.val = frontVal;
        return head;

    }


}
