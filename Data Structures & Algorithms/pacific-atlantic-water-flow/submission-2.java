class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        List<List<Integer>> res = new ArrayList<>();

        // top
        for(int i = 0; i < n; i++) {
            dfs(heights, m, n, 0, i, heights[0][i], pacific);
        }

        // left
        for(int i = 0; i < m; i++) {
            dfs(heights, m, n, i, 0, heights[i][0], pacific);
        }

        // // right
        for(int i = 0; i < m; i++) {
            dfs(heights, m, n, i, n - 1, heights[i][n - 1], atlantic);
        }

        // // bottom
        for(int i = 0; i < n; i++) {
            dfs(heights, m, n, m - 1, i, heights[m - 1][i], atlantic);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> r = new ArrayList<>();
                    r.add(i);
                    r.add(j);
                    res.add(r);
                }
            }
        }

        return res;
    }

    public void dfs(int[][] heights, int m, int n, int r, int c, int prevHeight, boolean[][] visited) {
        if(!isValid(r, c, m, n) || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        dfs(heights, m, n, r - 1, c, heights[r][c], visited);
        dfs(heights, m, n, r + 1, c, heights[r][c], visited);
        dfs(heights, m, n, r, c - 1, heights[r][c], visited);
        dfs(heights, m, n, r, c + 1, heights[r][c], visited);
    }

    public boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }
}
