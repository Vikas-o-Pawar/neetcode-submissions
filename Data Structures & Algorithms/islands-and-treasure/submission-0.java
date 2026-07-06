class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 0) {
                    // found a treasure chest now calculate min distance
                    dfs(grid, r - 1, c, m, n, 0); // up from 0
                    dfs(grid, r + 1, c, m, n, 0); // down from 0
                    dfs(grid, r, c + 1, m, n, 0); // right from 0
                    dfs(grid, r, c - 1, m, n, 0); // left from 0
                }
            }
        }
    }

    public void dfs(int[][] grid, int r, int c, int m, int n, int count) {
        if(!isValid(r, c, m, n)) {
            // out of bounds; go back.
            return;
        }

        if(grid[r][c] == 0 || grid[r][c] == -1) {
            return;
        }

        count++;

        if(grid[r][c] <= count) {
            // the current cell already has lesser count than one we're choosing
            return;
        }
        

        grid[r][c] = count;

        dfs(grid, r - 1, c, m, n, count); 
        dfs(grid, r + 1, c, m, n, count); 
        dfs(grid, r, c + 1, m, n, count);
        dfs(grid, r, c - 1, m, n, count); 
    }

    public boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m && c >= 0 && c < n);
    }
}
