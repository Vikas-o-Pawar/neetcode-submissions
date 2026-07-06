class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        List<List<Integer>> result = new ArrayList<>();

        // top (0, c) c-> 0.. n-1
        for(int i = 0; i < n; i++) {
            dfs(heights, pacific, 0, i, heights[0][i]);
        }

        // left (r, 0) r -> 0 ...  r-1
        for(int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);
        }

        // right (r, n-1) -> r -> 0 ... n-1
        for(int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1, heights[i][n - 1]);
        }

        // bottom
        for(int i = 0; i < n; i++) {
            dfs(heights, atlantic, m - 1, i, heights[m-1][i]);
        }

        // printDisplay(atlantic);
        // System.out.println("***");
        // printDisplay(pacific);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(j);

                    result.add(ls);
                }
            }
        }

        return result;
    }

    void printDisplay(boolean[][] arr) {
        for(boolean[] a: arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight) {
        if(!isValid(heights, r, c) || visited[r][c]) {
            return; // out of bounds
        }

        if(prevHeight <= heights[r][c])
            visited[r][c] = true;
        else 
            return;
        
        prevHeight = heights[r][c];

        // up
        dfs(heights, visited, r - 1, c, prevHeight);

        // down
        dfs(heights, visited, r + 1, c, prevHeight);

        // left
        dfs(heights, visited, r, c - 1, prevHeight);

        // right
        dfs(heights, visited, r, c + 1, prevHeight);
    }

    boolean isValid(int[][] heights, int r, int c) {
        int m = heights.length;
        int n = heights[0].length;

        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }

}