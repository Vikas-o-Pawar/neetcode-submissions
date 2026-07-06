class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int r = 0; r < n; r++) {
            dfs(heights, pacific, m, n, 0, r, heights[0][r]);
        }

        for(int c = 0; c < m; c++) {
            dfs(heights, pacific, m, n, c, 0, heights[c][0]);
        }

        // bottom
        for(int r = 0; r < n; r++) {
            dfs(heights, atlantic, m, n, m - 1, r, heights[m - 1][r]);
        }

        // right
        for(int c = 0; c < m; c++) {
            dfs(heights, atlantic, m, n, c, n - 1, heights[c][n - 1]);
        }

        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(atlantic[i][j] && pacific[i][j]) {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    res.add(l);
                }
            }
        }

        return res;
    }

    public void dfs(int[][] heights, boolean[][] visited, int m, int n, int r, int c, int prev) {
        if(!isValid(m, n, r, c) || visited[r][c]) {
            return;
        }

        if(heights[r][c] < prev) {
            return;
        }

        visited[r][c] = true;

        // up 
        dfs(heights, visited, m, n, r - 1, c, heights[r][c]);

        // down
        dfs(heights, visited, m, n, r + 1, c, heights[r][c]);

        // left
        dfs(heights, visited, m, n, r, c - 1, heights[r][c]);

        // right
        dfs(heights, visited, m, n, r, c + 1, heights[r][c]);
    }

    public boolean isValid(int m, int n, int r, int c) {
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }
}
