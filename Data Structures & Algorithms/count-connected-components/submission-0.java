class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int comp = 0;

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                comp++;
                dfs(i, adj, visited);
            }
        }

        return comp;
    }

    public void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        if(adj.get(node).isEmpty()) {
            return;
        }

        if(visited[node]) {
            return;
        }

        visited[node] = true;

        for(int a: adj.get(node)) {
            if(!visited[a]) {
                dfs(a, adj, visited);
            }
        }

        return;
    }   
}
