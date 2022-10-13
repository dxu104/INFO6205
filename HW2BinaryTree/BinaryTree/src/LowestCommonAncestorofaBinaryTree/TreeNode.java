package LowestCommonAncestorofaBinaryTree;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }



    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();
    //Store all nodes and their right and left children nodes.
    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        //this while loop will put p.val into the hashset.then parent.get() will return
        //p's parent node. Finally, we will get all parent node.
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        //if the level which q located in is shallower p(q level is 5,p level is 10),which means q is common nodes (visited contain q already)
        //if the q level is deeper than p level, visited hashset does not contain q levels.
        //Then we need to use parent.get() to bring get q's parent. until visited hash contain q.
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        //after we finish two while loop, if we still do not return, we return null.
        return null;
    }
}


