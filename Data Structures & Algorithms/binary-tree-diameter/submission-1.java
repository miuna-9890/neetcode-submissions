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
    int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return maxD;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        int d = leftH + rightH;
        maxD = Math.max(maxD, d);

        return 1 + Math.max(leftH, rightH);
    }
}
