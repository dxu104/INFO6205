package MaximumWidthofBinaryTree;


import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
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


    public int widthOfBinaryTree(TreeNode root) {
        //using queue to receive all nodes in each level.
        Queue<TreeNode> queue = new LinkedList<>();
        //using qIndex to receive the index of those added nodes
        Queue<Integer> qIndex = new LinkedList<>();
        queue.add(root);//store root node.
        qIndex.add(0);//assuming root's index is 0;
        int max=0;
        while(!queue.isEmpty()){
            int size = queue.size();//record how many children nodes we added during previous loop.
            int start =0;
            int end =0;
            for(int i=0;i<size;i++)
            {
                TreeNode node= queue.poll(); //record the current node;
                int index = qIndex.poll(); //record the its index of current node at same time.
                if(i==0) start = index;//record the index of the first node in this level.
                if(i==size-1) end = index; //recorde the index of the last node in this level;
                //now we start to pass the index and node to the children'node
                if(node.left!=null){
                    queue.add(node.left);
                    qIndex.add(2*index);//based on the picture,we know the relationship. And for a non-full binary tree, the relationship between the indices of a parent and its child node still holds.
                }
                if(node.right!=null){
                    queue.add(node.right);
                    qIndex.add(2*index+1);
                }

            }
            //now we exit the one loop(one level).And we also know the end and start index; then we record and update the width this level
            max=Math.max(max,end-start+1);
        }
        return max;
    }
}