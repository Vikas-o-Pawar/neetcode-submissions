class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int i = 0;
            int size = q.size();
            count++;

            while(i < size) {
                int[] currPos = q.poll();

                // go to all directions
                for(int[] dir: dirs) {
                    int x = currPos[0] + dir[0];
                    int y = currPos[1] + dir[1];

                    if(isSafe(x, y, m, n) && grid[x][y] == 1) {
                        q.offer(new int[] {x, y});
                        grid[x][y] = 2;
                    }
                }

                i++;
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return Math.max(count - 1, 0);
    }

    boolean isSafe(int x, int y, int r, int c) {
        return (x >= 0 && x < r) && (y >= 0 && y < c);
    }
}