package RecoverBST;


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


    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        dfs(root,list);
        TreeNode first = null;
        TreeNode second = null;
        //
        for(int i=0;i<list.size()-1;++i) {
            if(list.get(i).val>list.get(i+1).val) {
                //use second to store the second node needed to be exchanged,
                //whose index should be i+1, the smaller one(i+1) do not belong to
                // this place.
                second = list.get(i+1);
                //use first to store the first node needed to be exchanged,
                //whose index should be i. because list.get(i) is larger than
                //list.get(i+1). those codes in the if part will only be run one time.
                if(first==null) {
                    first = list.get(i);
                }
            }
        }
        //exchange their values.
        if(first!=null && second!=null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    //
    private void dfs(TreeNode node,List<TreeNode> list) {
        if(node==null) {
            return;
        }
        dfs(node.left,list);
        list.add(node);
        dfs(node.right,list);
    }
}

