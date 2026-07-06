class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == '1') {
                    // island found
                    dfs(grid, r, c, m, n);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int r, int c, int m, int n) {
        if(!isValid(r, c, m, n) || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        // up down left right
        dfs(grid, r - 1, c, m, n);
        dfs(grid, r + 1, c, m, n);
        dfs(grid, r, c - 1, m, n);
        dfs(grid, r, c + 1, m, n);
    }

    public boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }

}
