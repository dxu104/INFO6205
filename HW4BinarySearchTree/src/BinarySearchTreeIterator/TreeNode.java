package BinarySearchTreeIterator;


import java.util.ArrayList;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }





class BSTIterator {

    // Pointer to the next smallest element in the BST
    //for point to the 0th, we initialize index to -1
    int index = -1;

    // Array containing all the nodes in the sorted order
    //put the node.val into the array
    ArrayList<Integer> nodesSorted = new ArrayList<Integer>();


    public BSTIterator(TreeNode root) {

        // Call to flatten the input binary search tree
        inorder(root);
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return ;
        }

        inorder(root.left);
        nodesSorted.add(root.val);
        inorder(root.right);
    }


    public int next() {
        return nodesSorted.get(++index);
    }


    public boolean hasNext() {
        return index + 1 < nodesSorted.size();
    }
}}

