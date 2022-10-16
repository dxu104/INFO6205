package isSameTree;

import java.util.LinkedList;
import java.util.Queue;

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // BFS
        Queue<TreeNode> tmpQueue = new LinkedList<TreeNode>();
        tmpQueue.offer(p);
        tmpQueue.offer(q);
        while(!tmpQueue.isEmpty()){
            p = tmpQueue.poll();
            q = tmpQueue.poll();
            //maybe temQueue is not null
            if(p == null && q == null){
                continue;
            }
            if(p == null || q == null){
                return false;
            }
            if(p.val != q.val){
                return false;
            }
            tmpQueue.offer(p.left);
            tmpQueue.offer(q.left);

            tmpQueue.offer(p.right);
            tmpQueue.offer(q.right);
        }
        return true;
    }
}
