class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j, grid, m, n);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void dfs(int r, int c, char[][] grid, int m, int n) {
        if(!isValid(r, c, m, n) || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        // up 
        dfs(r - 1, c, grid, m, n);

        // down
        dfs(r + 1, c, grid, m, n);

        // left
        dfs(r, c - 1, grid, m, n);

        // right
        dfs(r, c + 1, grid, m, n);
    }

    public boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }
}