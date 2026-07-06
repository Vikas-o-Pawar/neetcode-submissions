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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }

        if(root.val == subRoot.val) {
            boolean same = isSame(root, subRoot);

            if(same) {
                return true;
            }
        } 

        boolean left = isSubtree(root.left, subRoot);

        if(left) return true;

        boolean right = isSubtree(root.right, subRoot);

        if(right) return true;

        return false;
    }

    public boolean isSame(TreeNode p, TreeNode q) {
        if((p == null && q != null) || (q == null && p != null)) {
            return false;
        }

        if(p == null && q == null) {
            return true;
        }

        if(p.val != q.val) {
            return false;
        }

        boolean left = isSame(p.left, q.left);
        
        if(!left) return false;

        boolean right = isSame(p.right, q.right);

        if(!right) return false;

        return true;
    }

    
}