class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 1) {
                    maxIsland = Math.max(dfs(grid, m, n, r, c), maxIsland);
                }
            }
        }

        return maxIsland;
    }

    public int dfs(int[][] grid, int m, int n, int r, int c) {
        if(!isValid(m, n, r, c) || grid[r][c] == 0) {
            // visited
            return 0;
        }

        grid[r][c] = 0; // marks as visited

        // up, down, left and right
        int up = dfs(grid, m, n, r - 1, c);
        int down = dfs(grid, m, n, r + 1, c);
        int left = dfs(grid, m, n, r, c - 1);
        int right = dfs(grid, m, n, r, c + 1);

        return 1 + up + down + left + right;
    }

    public boolean isValid(int m, int n, int r, int c) {
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }
}
