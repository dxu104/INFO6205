package Q1;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode<Integer> {
    public Integer data;
    public TreeNode<Integer> left;
    public TreeNode<Integer> right;

    public TreeNode<Integer> nextLeft;

    public TreeNode(Integer data){
        this.data = data;
    }

    public void populateNextRight(TreeNode root){


                if(root==null) {
                    return ;
                }
                TreeNode pre = root;
                while(pre.right!=null) {
                    TreeNode tmp = pre;
                    while(tmp!=null) {
                        tmp.right.nextLeft = tmp.left;
                        if(tmp.nextLeft!=null) {
                            tmp.left.nextLeft = tmp.nextLeft.right;
                        }
                        //
                        tmp = tmp.nextLeft;
                    }
                    pre = pre.right;
                }

            }
        }




