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
    private int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int pd = preorder.length;
        int od = inorder.length;

        for(int i = 0; i < od; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(map, preorder, 0, pd - 1);    
    }

    public TreeNode buildTree(HashMap<Integer, Integer> map, int[] preorder, int left, int right) {
        if(left > right || idx == preorder.length) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[idx++]);

        int idxInorder = map.get(node.val);

        // 0 ... idxInorder - 1 left of node
        // idxInorder + 1.... n - 1 right of node
        node.left = buildTree(map, preorder, left, idxInorder - 1);
        node.right = buildTree(map, preorder, idxInorder + 1, right);

        return node;
    }
}