package BinaryTreeZigzagLevelOrderTraversal;


import java.util.*;

//Definition for a binary tree node.
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

// res is an object,and it can be used as a class attribute.
// And by doing so,we could print result in Test class.
List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //a method return a two-dimensional arrayList
        if (root == null) return res;
        //we need a Queue to operate argument TreeNode，such as .poll (TreeNode) and .offer(TreeNode.right)
        //public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Queue<E>, Cloneable, Serialzable
        // since LinkedList class implement Queue interface，we could use .poll and .offer
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //we define a boolean variable to make the node in the odd level added in left to right.
        // and make the node in the even level added in  right to left way.
        boolean isLeft = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            //  we'll initialize each element of ArrayList(res) with another ArrayList
            //  to store the nodes in each level.
            List<Integer> levelList = new ArrayList<Integer>();
            //get the size of queue then we know how many nodes we should poll from the queue.
            int level_length = queue.size();
            for (int i = 0; i < level_length; i++) {
                //record each node, since we need to offer their right and left children。
                TreeNode node = queue.poll();
                // we put the node.val into each level.
                levelList.add(node.val);
                // First,verify weather right children and left children of node exist.
                // second,record them, each for loop. we only can record 0 to 2 nodes.
                //if level_length is 1,we can add at most 2. then next for loop level_length would be 2.
                // we can add at most 4 node to the queue. so on so forth. Until

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
            //after jump out for loop, we finish all nodes in a certain level.
            if(isLeft){
                //for odd level, we do not reverse this list.
                //for even level, we reverse this list.

                Collections.reverse(levelList);

            }
            //odd not reverse. even reverse.
            isLeft=!isLeft;
                res.add(levelList);
        }
        return res;
    }
}



