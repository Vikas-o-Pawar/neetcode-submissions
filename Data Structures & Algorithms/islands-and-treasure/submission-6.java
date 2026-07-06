class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        // up down left right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()) {
            int[] d = q.poll();

            for(int[] dir: dirs) {
                int x = d[0] + dir[0];
                int y = d[1] + dir[1];

                if(isValid(x, y, m, n) && grid[x][y] == Integer.MAX_VALUE) {
                    grid[x][y] = Math.min(grid[d[0]][d[1]] + 1, grid[x][y]);
                    q.offer(new int[]{x, y});
                }

            }
        }
    }

    public boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }
}
