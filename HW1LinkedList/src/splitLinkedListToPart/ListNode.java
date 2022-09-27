package splitLinkedListToPart;


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


        class Solution {
            public ListNode[] splitListToParts(ListNode head, int k) {
                ListNode[] arr = new ListNode[k];//creat a ListNode array
                int len = 0;
                //Get the length of Array.
                for (ListNode cur = head; cur != null; cur = cur.next)
                    len++;
                // n : minimum guaranteed sub-LinkedList size;
                // modulus : extra nodes distributed to the first modulus array;
                int n = len / k, modulus = len % k;

                ListNode cur = head, prev = null;
                if (len >= k) {
                    for (int i = 0; cur != null && i < k; i++, modulus--) {
                        //Firstly,we store the head of sub-LinkedList in each array
                        arr[i] = cur;
                        for (int j = 0; j < n + (modulus > 0 ? 1 : 0); j++) {
                            prev = cur;//Store the position of the tail of sub-LinkedList.
                            cur = cur.next;// move our cur node to next for a new loop.
                        }
                        //Lastly,since we already finished the job of traversing a sub-LinkedList,break the connection.
                        prev.next = null;
                    }
                    // we finished the job of traversing all k sub-LinkedList.
                    return arr;
                }

                // Conner Case when length of LinkedList is less than K.
                else {
                    cur = head; //relocated
                    int i;
                    // first part, each sub-LinkedList only have one node.
                    for (i = 0; cur != null && i < len; i++) {
                        arr[i] = cur;// store the head node of a sub-LinkedList.
                        prev = cur;// store the position of tail of a sub-LinkedList.
                        cur = cur.next;//move current node to next.
                        prev.next = null;// break the connection
                    }
                    //second part, each sub-LinkedList array is null.
                    for (int j = i + 1; j < k; j++) {
                        arr[j] = null;
                    }
                    return arr;

                }

            }

        }

