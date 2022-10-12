package SymmetricTree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        return isSymmetriacalCor(root.left, root.right);

    }

    private boolean isSymmetriacalCor(TreeNode L, TreeNode R) {

        if (L == null && R == null) {
            return true;
        }
        // one is empty and another is not empty (we already expel both are null)
        // therefore return false.
        if (L == null || R == null) {
            return false;
        }
        if (L.val != R.val) {
            return false;
        }
        //simultaneously compare L.left and R.right. And L.right with R.left.
        return isSymmetriacalCor(L.left, R.right) && isSymmetriacalCor(L.right, R.left);
    }
}



