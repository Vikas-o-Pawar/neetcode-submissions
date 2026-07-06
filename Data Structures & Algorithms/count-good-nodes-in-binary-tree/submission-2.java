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

    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, root.val);
    }

    public int goodNodesHelper(TreeNode root,  int max) {
        if(root == null) {
            return 0;
        }

        int c = 0;

        if(root.val >= max) {
            c++;
        }

        int left = goodNodesHelper(root.left, Math.max(root.val, max));
        int right = goodNodesHelper(root.right, Math.max(root.val, max));

        return c + left + right;        
    }
}