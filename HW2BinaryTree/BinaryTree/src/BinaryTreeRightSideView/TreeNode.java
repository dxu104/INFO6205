package BinaryTreeRightSideView;


import java.util.ArrayList;
import java.util.List;

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

    //define a global res list. this is also a class attribute.
      List<Integer> res = new ArrayList();

    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return res;//exit condition
        int level=0;
        helper(root,level);
        return res;
    }

    public void helper(TreeNode node,int level){
// since generally speaking, res.size() is larger than level,
// when we found there is a node in the new level(usually this level is maximum one among previous existed node)
// level equal to res.size,we add this node.val.
        if(level==res.size()){
            res.add(node.val);
        }
        //we always traverse right firstly.
        if(node.right!=null) helper(node.right,level+1);
        //when we traverse left, its level is the value when we pass the arguments int level.
        //unless right is null, otherwise we never consider left.
        if(node.left!=null) helper(node.left,level+1);

    }
}