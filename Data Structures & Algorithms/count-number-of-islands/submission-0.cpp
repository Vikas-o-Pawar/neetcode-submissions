class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int count = 0;
        int m = grid.size();
        int n = grid[0].size();

        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, m, n, i, j);
                }
            }
        }

        return count;
    }

    void dfs(vector<vector<char>> &grid, int m, int n, int r, int c) {
        if(!isValid(m, n, r, c)) {
            return;
        }

        if(grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        // up
        dfs(grid, m, n, r - 1, c);

        // down
        dfs(grid, m, n, r + 1, c);

        // left
        dfs(grid, m, n, r, c - 1);

        // right
        dfs(grid, m, n, r, c + 1);

        return;
    } 

    bool isValid(int m, int n, int r, int c) {
        return (r >= 0 && r < m && c < n && c >= 0);
    }
};
