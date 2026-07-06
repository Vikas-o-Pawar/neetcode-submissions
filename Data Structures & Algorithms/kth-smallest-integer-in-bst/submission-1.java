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
    int kGlobal = 0;
    public int kthSmallest(TreeNode root, int k) {
        kGlobal = k;
        return inorder(root);
    }

    public int inorder(TreeNode root) {
        if(root == null) {
            return -1;
        }

        int left = inorder(root.left);
        if(left != -1) return left;
        
        kGlobal--;

        if(kGlobal == 0) {
            return root.val;
        }

        int right = inorder(root.right);
        if(right != -1) return right;

        return -1;  
    }
}