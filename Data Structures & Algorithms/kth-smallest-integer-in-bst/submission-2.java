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
    int res = 0;
    boolean solfound = false;
    int pk = 0;

    public int kthSmallest(TreeNode root, int k) {
        pk = k;
        helper(root, k);
        return res;
    }

    public void helper(TreeNode root, int k) {
        if(root == null || solfound) return;

        helper(root.left, pk);
        pk--;

        if(pk == 0) {
            res = root.val;
            solfound = true;
            return;
        }

        helper(root.right, pk);
    }
}