/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        sb.append(root.val);
        sb.append("#");

        while(!q.isEmpty()) {
            int i = 0;
            int size = q.size();

            while(i++ < size) {
                TreeNode node = q.poll();

                if(node.left != null) {
                    q.offer(node.left);
                    sb.append(node.left.val + ",");
                } else {
                    sb.append("n,");
                }
                
                if(node.right != null) {
                    q.offer(node.right);
                    sb.append(node.right.val + ",");
                } else {
                    sb.append("n,");
                }
            }

            sb.deleteCharAt(sb.length() - 1);
            sb.append("#");
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode node = null;
        if(data.length() == 0) return node;

        String[] sArr = data.split("#");
        int i = 0;
        Queue<TreeNode> q = new LinkedList<>();
        node = new TreeNode(Integer.parseInt(sArr[i++]));
        q.offer(node);
        
        while(!q.isEmpty()) {
            String[] levelArr = sArr[i++].split(",");
            int lPtr = 0;

            int k = 0;
            int size = q.size();

            while(k < size) {
                TreeNode polled = q.poll();

                String lStr = levelArr[lPtr++];
                String lStr2 = levelArr[lPtr++];

                if(lStr.equals("n")) {
                    polled.left = null;
                } else {
                    polled.left = new TreeNode(Integer.parseInt(lStr));
                    q.offer(polled.left);
                }

                if(lStr2.equals("n")) {
                    polled.right = null;
                } else {
                    polled.right = new TreeNode(Integer.parseInt(lStr2));
                    q.offer(polled.right);
                }
                k++;
            }
        }
                
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));