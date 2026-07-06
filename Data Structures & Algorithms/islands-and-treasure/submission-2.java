class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    
                    // up
                    dfs(grid, i - 1, j, m, n, 0);

                    // down
                    dfs(grid, i + 1, j, m, n, 0);

                    // left
                    dfs(grid, i, j - 1, m, n, 0);

                    // right
                    dfs(grid, i, j + 1, m, n, 0);

                }
            }
        }
    }

    public void dfs(int[][] grid, int r, int c, int m, int n, int count) {
        if(!isValid(m, n, r, c) || grid[r][c] == -1 || grid[r][c] == 0) {
            return;
        }

        count++;
        // valid cell
        if(grid[r][c] <= count) {
            return;
        }

        grid[r][c] = count;
        dfs(grid, r - 1, c, m, n, count);

        dfs(grid, r + 1, c, m, n, count);

        dfs(grid, r, c - 1, m, n, count);

        dfs(grid, r, c + 1, m, n, count);
    }

    public boolean isValid(int m, int n, int r, int c){ 
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }
}
