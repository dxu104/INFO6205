package RemoveLinkedListElements;

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

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        //we need a sentinel to issue the situation
        //that all nodes whose value equals val at the beginning.
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;// the reason why we do not return head, which is the sitution
        //that all nodes whose value equals val at the beginning
        //if head.val = val at the beginning,we use prev.next=curr.next,we delete the head.
        //since sentinel=prev, they are same. sentineal alwasys pointed to the node whose val != val.
        //Therefore, we return sentinel.next.
        //if we return head,only cur node point head, and it only can hanle the node after head.
        //sentinel is the only one charging the head.
        //Besides above situation, when we run prev=curr,curr=curr.next. Prev will move forward,therefore,we could not return prev again.
    }
}

