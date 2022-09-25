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

    class RotateList {
        public ListNode rotateRight(ListNode head, int val) {
            // Remove all nodes whose value equals val at the head
            while (head != null && head.val == val) {
                head = head.next;
            }

            ListNode cur = head;

            while (cur != null && cur.next != null) {
                if (cur.next.val == val) {
                    if (cur.next == null) {
                        cur.next = cur.next.next;

                    }
                } else {
                    cur = cur.next;

                }
            }
            return head;

        }
    }
}

