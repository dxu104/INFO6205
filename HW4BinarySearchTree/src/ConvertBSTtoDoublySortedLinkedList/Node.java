package ConvertBSTtoDoublySortedLinkedList;


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }



class Solution {
    // the smallest (first/origin) and the largest (last/previous node) nodes
    Node first = null;
    Node last = null;

    public void helper(Node node) {
        if (node != null) {
            // traverse leftTree
            helper(node.left);
            // if last exist,we need to connect to current.
            if (last != null) {
                // link the previous node (last)
                // with the current one (node)
                //we can assume the .right means next.
                last.right = node;
                //and .left means prev.
                node.left = last;
                //then we form a doubly LinkedList.
            }
            //if last is null, we set the origin.
            else {
               //else part will only be run one time at the beginning.
                first = node;
            }
            //each time,we need to update the previous node to current node.
            last = node;
            // traverse the right tree.
            helper(node.right);
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        helper(root);
        // after finish all connection steps,we close the double linkedList.
        last.right = first;
        first.left = last;
        return first;
    }
}}
