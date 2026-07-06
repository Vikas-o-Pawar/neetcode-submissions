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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 0;
        int size = q.size();

        while(!q.isEmpty()) {

            while(i < size) {
                TreeNode r = q.poll();

                if(i == size - 1) {
                    result.add(r.val);
                }

                if(r.left != null) {
                    q.offer(r.left);
                }

                if(r.right != null) {
                    q.offer(r.right);
                }

                i++;
            }

            size = q.size();
            i = 0;
        }

        return result;
    }
}