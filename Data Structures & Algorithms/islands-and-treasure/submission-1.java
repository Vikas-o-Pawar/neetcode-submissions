class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0) return;

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0},{0, 1}, {0, -1}}; // down, up, right, left

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] dir: dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || 
                    grid[newRow][newCol] != Integer.MAX_VALUE) {
                        continue;
                }

                grid[newRow][newCol] = grid[row][col] + 1;
                q.offer(new int[]{newRow, newCol});
            }
        }
    }
}
