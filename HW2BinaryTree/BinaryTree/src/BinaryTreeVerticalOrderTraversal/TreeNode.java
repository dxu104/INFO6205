package BinaryTreeVerticalOrderTraversal;

import java.util.*;

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



    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue =new LinkedList<>();
        Queue<Integer> columns = new LinkedList<>();
        queue.add(root);
        columns.add(0);
        int min =0;
        int max=0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int col = columns.poll();
            if(!map.containsKey(col)){
                map.put(col,new ArrayList<Integer>());
            }
            map.get(col).add(node.val);
            // we must traverse node.left firstly
            //since  the order is [3,0,1],we must poll 9 first
            // then 0 node will be added and poll before than 1.
            // if we traverse node.left firstly, 8 will be poll first
            // then 7 and 1 will be added, then 9 will be polled,
            // 0 and 1 will be added. then 1 will be poll first,
            // and will 1.val will be added into map.get(2).add(1) firstly. then wrong.
            if(node.left!=null){
                //  BFS, put node, col into queue at the same time
                queue.add(node.left);
                //Every left child access col - 1 while right child col + 1
                columns.add(col-1);
                //update min value
                min=Math.min(min,col-1);
            }

            if(node.right!=null){
                queue.add(node.right);
                columns.add(col+1);
                max=Math.max(max,col+1);
            }

        }
        //res is two-dimensional list. map.get(i) will give us all one dimensional list,
        // that will be added into res.
        for(int i = min; i<=max;i++){
            res.add(map.get(i));
        }
        return res;
    }
}
