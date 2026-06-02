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

class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, -Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, int min, int max) {
        boolean check = false;
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            check = false;
        } else {
            check = true;
        }

        return check && dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}
