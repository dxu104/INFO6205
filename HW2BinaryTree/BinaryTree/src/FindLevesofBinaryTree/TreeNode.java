package FindLevesofBinaryTree;

import java.util.ArrayList;
import java.util.List;

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

    private List<List<Integer>> solution=new ArrayList<>();
    private int getHeight(TreeNode root){
        //return -1 for null nodes
        if(root==null){
            return -1;
        }
        //each recursion,the most left point in the most depth level
        // was passing into the getHeight method, since his left and right children is null;
        //currentHeight = max(-1,-1)+1=0,we also add node.val into solution[0]return 0 to his parent node leftHeight =0.
        //Then his parent will process int rightHeight = getHeight(root.right)
        // Then we will get rightHeight=0; and also node.val into solution[0];
        //then parent node's currHeight=1; and also was added into solution[1]
        //in this case, to all node whose two children are null, will be added into solution[0]
        // and itself will be added into solution[1].when curHeight =1,return 1 to left Height or right Height
        //And current=2,3,4 etc.
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int currHeight=Math.max(leftHeight,rightHeight)+1;
        if(this.solution.size()==currHeight){
            this.solution.add(new ArrayList<>());
        }
        this.solution.get(currHeight).add(root.val);
        return currHeight;

    }
    public List<List<Integer>> findLeaves(TreeNode root){
        this.solution=new ArrayList<>();
        this.getHeight(root);
        return this.solution;
    }
}
