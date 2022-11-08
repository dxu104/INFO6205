package InorderSuccessinBST;



  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }



//looking for the smallest number larger than target in a BST
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode successor = null;

        while (root != null) {

            // as long as p.val is less than current node(root),
            //we update(decrease) our current to close the p.val in order to
            //find the one just larger than p.val
            if (p.val < root.val) {
                successor = root;
                root = root.left;


                //as long as p.val is >= current node(root),
                //we update(increase) our current node to close the p.val in order to
                //find the one just larger than p.val. Then we will record successor.
            } else {
                root = root.right;
            }
        }

        return successor;
    }
}