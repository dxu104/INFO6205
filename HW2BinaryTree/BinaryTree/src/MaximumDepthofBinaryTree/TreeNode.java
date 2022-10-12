package MaximumDepthofBinaryTree;

//Definition for a binary tree node.
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



    public int maxDepth(TreeNode root) {
        // when we receive a root is null, we end the recursion.
        //And at the meanwhile, we
        if(root == null) return 0;
        //passing argument for next recursion.
        //return the maximum depth of previous node to the method we call lastly.
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }
}

