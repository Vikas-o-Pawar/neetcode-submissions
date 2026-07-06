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
    boolean balance = true;

    public boolean isBalanced(TreeNode root) {
        int r = helper(root);

        return balance;    
    }

    public int helper(TreeNode root) {
        if(root == null) {
            return -1;
        }

        int left = 1 + helper(root.left);
        int right = 1 + helper(root.right);

        if(Math.abs(left - right) > 1) {
            balance = false;
        }

        return Math.max(left, right);
    } 
}