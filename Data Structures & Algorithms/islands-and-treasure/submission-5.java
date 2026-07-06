class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 0) {
                    // found a treasure chest, start a dfs from here
                    dfs(grid, m, n, r, c, 0);
                }
            }
        }
    }

    public void dfs(int[][] grid, int m, int n, int r, int c, int prev) {
        if(!isValid(m, n, r, c) || grid[r][c] == -1) {
            return;
        }

        if(grid[r][c] < prev) {return;}
        
        grid[r][c] = prev;
        // up
        dfs(grid, m, n, r - 1, c, prev + 1);

        // down
        dfs(grid, m, n, r + 1, c, prev + 1);

        // left
        dfs(grid, m, n, r, c - 1, prev + 1);

        // right
        dfs(grid, m, n, r, c + 1, prev + 1);


    }

    public boolean isValid(int m, int n, int r, int c) {
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }
}
