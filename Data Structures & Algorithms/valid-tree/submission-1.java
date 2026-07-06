class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) 
            adj.add(new ArrayList<>());

        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        if(!dfs(0, 0, adj, visited)) return false;

        for(boolean v: visited) if(!v) return false;

        return true;
    }

    public boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for(int a: adj.get(node)) {
            if(!visited[a]) {
                if(!dfs(a, node, adj, visited)) return false;
            } else if(a != parent) {
                return false;
            }
        }

        return true;
    }
}
