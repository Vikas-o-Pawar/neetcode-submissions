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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int res = helper(root);
        return diameter;
    }

    public int helper(TreeNode root) {
        if(root == null) {
            return -1;
        }

        int left = 1 + helper(root.left);
        int right = 1 + helper(root.right);

        diameter = Math.max(left + right, diameter);

        return Math.max(left, right);
    }
}
