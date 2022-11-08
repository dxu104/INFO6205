package SerializeandDeserializeBST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }



public class Codec {
    public String serialize_dfs(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = serialize_dfs(root.left, str);
            str = serialize_dfs(root.right, str);
        }
        return str;
    }

    public String serialize(TreeNode root) {
        return serialize_dfs(root, "");
    }


    public TreeNode deserialize_dfs(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(l.get(0)));
        l.remove(0);
        root.left = deserialize_dfs(l);
        root.right = deserialize_dfs(l);

        return root;
    }

    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new ArrayList<String>(Arrays.asList(data_array));
        return deserialize_dfs(data_list);
    }


}}

