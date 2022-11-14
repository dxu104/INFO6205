package Q3;

import java.util.ArrayList;
import java.util.List;



    // Java program to demonstrate
// insert operation in binary
// search tree
    class BinarySearchTree {
        public static List<Integer> result = new ArrayList<>();


        /* Class containing left
        and right child of current node
        * and key value*/
        class TreeNode {
            int key;
            TreeNode left, right;

            public TreeNode(int item)
            {
                key = item;
                left = right = null;
            }
        }

        // Root of BST
         TreeNode root;

        // Constructor
        BinarySearchTree() { root = null; }

        BinarySearchTree(int value) { root = new TreeNode(value); }

        // This method mainly calls insertRec()
       public void insert(int key) { root = insertRec(root, key); }

        /* A recursive function to
        insert a new key in BST */
        public TreeNode insertRec(TreeNode root, int key)
        {

		/* If the tree is empty,
		return a new node */
            if (root == null) {
                root = new TreeNode(key);
                return root;
            }

            /* Otherwise, recur down the tree */
            else if (key < root.key)
                root.left = insertRec(root.left, key);
            else if (key > root.key)
                root.right = insertRec(root.right, key);

            /* return the (unchanged) node pointer */
            return root;
        }

        // This method mainly calls InorderRec()
       public void inorder() { inorderRec(root); }

        // A utility function to
        // do inorder traversal of BST
       public void inorderRec(TreeNode root)
        {
            if (root != null) {
                inorderRec(root.left);
                result.add(root.key);
                System.out.println(result.toString());
                inorderRec(root.right);
            }
        }

        // Driver Code
        List<Integer> output = new ArrayList<>();




        public List<Integer> range(int [] arr,List<Integer>result) {
            int min = arr[0];
            int len = arr.length;
            int max = arr[len - 1];
            for (int i = 0; i < result.size(); i++) {


                if (min < result.get(i) && result.get(i) <= max) {
                    output.add(result.get(i));

                }
            }
            return output;
        }
        public static void main(String[] args) {
            int [] arr= new int[]{3,6};
            BinarySearchTree tree = new BinarySearchTree();

		/* Let us create following BST
			50
		/	 \
		30	 70
		/ \ / \
	20 40 60 80 */
            tree.insert(5);
            tree.insert(3);
            tree.insert(2);
            tree.insert(4);
            tree.insert(7);
            tree.insert(6);
            tree.insert(8);

            // print inorder traversal of the BST
            tree.inorder();
            List<Integer> output =tree.range(arr,result);
            System.out.println(output);
        }
    }
// This code is contributed by Ankur Narain Verma

