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
        List<Integer> ls = new ArrayList<>();
        inOrder(root, ls);

        for(int i = 1; i < ls.size(); i++) {
            if(ls.get(i) <= ls.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public void inOrder(TreeNode root, List<Integer> ls) {
        if(root == null) {
            return;
        }

        inOrder(root.left, ls);
        ls.add(root.val);
        inOrder(root.right, ls);
    }
}