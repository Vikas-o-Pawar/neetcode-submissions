class Solution {
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        int area = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int result = dfs(grid, m, n, i, j);

                area = std::max(result, area);
            }
        }

        return area;
    }

    int dfs(vector<vector<int>> & grid, int m, int n, int r, int c) {
        if(!isValidCell(m, n, r, c)) {
            return 0;
        }

        if(grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        int left = dfs(grid, m, n, r, c - 1);

        int right = dfs(grid, m, n, r, c + 1);

        int up = dfs(grid, m, n, r - 1, c);

        int down = dfs(grid, m, n, r + 1, c);

        return 1 + (left + right + up + down);
    }

    bool isValidCell(int m, int n, int r, int c) {
        return (r >= 0 && c >= 0 && r < m && c < n);
    }
};
