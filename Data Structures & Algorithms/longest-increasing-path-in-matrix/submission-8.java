class Solution {
    int[][] memo;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;

        int m = matrix.length;
        int n = matrix[0].length;
        memo = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j, m, n, matrix));
            }
        }

        return ans;
    }

    public int dfs(int i, int j, int m, int n, int[][] matrix) {
        if(memo[i][j] != 0) return memo[i][j];
        int r = 1;

        for(int[] dir: dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if(ni >= 0 && ni < m && nj >= 0 && nj < n &&  matrix[ni][nj] > matrix[i][j]) {
                // valid path
                r = Math.max(r, 1 + dfs(ni, nj, m, n, matrix));
            }
        }

        memo[i][j] = r;
        return r;
    }
}
