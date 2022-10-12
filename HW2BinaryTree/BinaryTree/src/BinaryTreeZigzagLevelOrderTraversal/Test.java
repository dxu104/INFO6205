package BinaryTreeZigzagLevelOrderTraversal;

import java.util.Deque;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        Integer[]num={3,9,20,null,null,15,7};
        TreeNode treeNode1 = new TreeNode();
        Test test = new Test();
        TreeNode rootNode = test.constructTree(num);

        treeNode1.levelOrder(rootNode);
        System.out.println(treeNode1.res);

    }
    public  TreeNode constructTree(Integer[] nums){
        if (nums.length == 0) return new TreeNode(0);
        Deque<TreeNode> nodeQueue = new LinkedList<>();

        TreeNode root = new TreeNode(nums[0]);
        nodeQueue.offer(root);
        TreeNode cur;
        int lineNodeNum = 2;
        int startIndex = 1;
        int restLength = nums.length - 1;

        while(restLength > 0) {

            for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                if (i == nums.length) return root;
                cur = nodeQueue.poll();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i]);
                    nodeQueue.offer(cur.left);
                }
                if (i + 1 == nums.length) return root;
                if (nums[i + 1] != null) {
                    cur.right = new TreeNode(nums[i + 1]);
                    nodeQueue.offer(cur.right);
                }
            }
            startIndex += lineNodeNum;
            restLength -= lineNodeNum;
            lineNodeNum = nodeQueue.size() * 2;
        }

        return root;
    }






}


