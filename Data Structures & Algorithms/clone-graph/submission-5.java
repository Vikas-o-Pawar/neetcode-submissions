/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        if(node == null) return null;
        return dfs(node, map);
    }

    Node dfs(Node node, Map<Node, Node> map) {
        if(map.containsKey(node)) {
            return map.get(node);
        }

        Node nn = new Node(node.val);
        map.put(node, nn);

        for(Node a: node.neighbors) {
            Node ret = dfs(a, map);
            nn.neighbors.add(ret);
        }

        return nn;
    }
}