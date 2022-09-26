package InsertSortedCircularLinkedList;


// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }


    class Solution {
        public Node insert(Node head, int insertVal) {
            Node node = new Node(insertVal);
            if (head == null) {
                node.next = node;
                return node;//stop the insert method.
            }
            Node cur = head;
            //How we can traverse circular  Linked-List just one time insread of repeatedly
            while (cur.next != head) {
                //when insertNode found cur node moved to a corrected location, it will insert itself.
                //for record the place of cur node to insert insertNode, we will break.
                //the first correct condition will be below one.
                if (cur.val <= insertVal && insertVal <= cur.next.val) {
                    break;
                    // second correct condition will be below one
                } else if (cur.next.val < cur.val) {
                    if (insertVal <= cur.next.val || insertVal >= cur.val) {
                        break;
                    }
                }
                cur = cur.next; //move the cur node to traverse whole list.
            }
            Node nextNode = cur.next;// we must store the node of cur.next as a new node called nextNode.
            cur.next = node;// connect cur node to insertNode.
            node.next = nextNode;//connect insertNode to nextNode
            return head;
        }

    }


