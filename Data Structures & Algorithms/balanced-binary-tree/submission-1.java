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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {

        getHeight(root);
        return isBalanced;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        if (Math.abs(leftH - rightH) > 1) {
            isBalanced = false;
        }

        return 1 + Math.max(leftH, rightH);
    }
}
