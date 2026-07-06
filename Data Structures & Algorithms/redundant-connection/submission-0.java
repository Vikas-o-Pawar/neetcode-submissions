class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        for(int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            int[] res = union(rank, parent, u, v);

            if(res[0] != -1) {
                return res;
            }
        }


        return new int[]{-1, -1};   
    }

    public int ultimateParent(int node, int[] parent) {
        if(parent[node] == node) {
            return node;
        }

        int up = ultimateParent(parent[node], parent);
        parent[node] = up;
        return up;
    }

    public int[] union(int[] rank, int[] parent, int u, int v) {
        int pu = ultimateParent(u, parent);
        int pv = ultimateParent(v, parent);

        if(pu == pv) {
            return new int[] {u, v};
        }

        if(rank[pu] < rank[pv]) {
            parent[pu] = pv; 
        } else if(rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }

        return new int[]{-1, -1};
    }
}