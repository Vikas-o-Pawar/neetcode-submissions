class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int time = 0;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()) {
            time++;
            int i = 0;
            int size = q.size();

            while(i < size) {
                int[] polled = q.poll();

                for(int[] dir: dirs) {
                    int x = polled[0] + dir[0];
                    int y = polled[1] + dir[1];

                    if(isSafe(x, y, m, n) && grid[x][y] == 1) {
                        q.offer(new int[]{x, y});
                        grid[x][y] = 2;
                    }

                }
                i++;
            }
        }

        for(int[] g: grid) {
            for(int k: g) {
                if(k == 1) {
                    // fresh orange found; all oranges can't be rotted
                    return -1;
                }
            }
        }

        return Math.max(0, time - 1);
    }

    public boolean isSafe(int r, int c, int m, int n) {
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }
}