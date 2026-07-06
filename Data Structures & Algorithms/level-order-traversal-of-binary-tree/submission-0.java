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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) {
            return ls;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int size = q.size();
        int i = 0;

        while(!q.isEmpty()) {
            List<Integer> miniLs = new ArrayList<>();

            while(i < size) {
                TreeNode node = q.poll();

                if(node.left != null) {
                    q.offer(node.left);
                }

                if(node.right != null) {
                    q.offer(node.right);
                }

                miniLs.add(node.val);

                i++;
            }

            i = 0;
            size = q.size();
            ls.add(miniLs);
        }

        return ls;
    }
}
