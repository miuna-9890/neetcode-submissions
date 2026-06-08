/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        Queue<TreeNode> q = new LinkedList<>();
        String ans = "";
        q.add(root);
        while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                if (curr == null) {
                    ans += "null" + ",";
                    continue;
                }
                ans += curr.val + ",";
                q.add(curr.left);
                q.add(curr.right);
        }
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while(!q.isEmpty() && i < vals.length) {
            TreeNode curr = q.poll();
            if (!vals[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(vals[i]));
                q.add(curr.left);
            }
            i++;
            if (i < vals.length && !vals[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(vals[i]));
                q.add(curr.right);
            }
            i++;
        }

        return root;
        
    }
}
