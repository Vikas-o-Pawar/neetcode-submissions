class Solution {
    int[][] memo;
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        memo = new int[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int best = 1;

        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (
                ni >= 0 && ni < matrix.length &&
                nj >= 0 && nj < matrix[0].length &&
                matrix[ni][nj] > matrix[i][j]
            ) {
                best = Math.max(best, 1 + dfs(matrix, ni, nj));
            }
        }

        memo[i][j] = best;
        return best;
    }
}