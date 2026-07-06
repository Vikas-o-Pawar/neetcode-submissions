class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[][] board = new int[n][n];
        helper(n, board, 0, res);
        return res;
    }

    public List<String> buildSolution(int[][] board, int n) {
    List<String> solution = new ArrayList<>();
    for (int r = 0; r < n; r++) {
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < n; c++) {
            sb.append(board[r][c] == 1 ? "Q" : ".");
        }
        solution.add(sb.toString());
    }
    return solution;
}

    public void helper(int n, int[][] board, int row, List<List<String>> res) {
        if(row == n) {
            res.add(buildSolution(board, n));
            return;
        }       
        
        for(int c = 0; c < n; c++) {
            if(isValidCell(row, c, n, board)) {
                // i can place the queen in this cell
                board[row][c] = 1; // queen placed
                helper(n, board, row + 1, res);
                board[row][c] = 0;
            } 
        }
        }


    // need to check only 3 directions - top right, top left, and top.
    public boolean isValidCell(int r, int c, int n, int[][] board) {
        return checkTop(r, c, board) &&
                checkTopLeft(r, c, board) &&
                checkTopRight(r, c, board);
    }

    public boolean checkTop(int r, int c, int[][] board) {
        while(r >= 0) {
            if(board[r][c] == 1) {
                return false;
            }

            r--;
        }

        return true;
    }

    public boolean checkTopLeft(int r, int c, int[][] board) {
        while(r >= 0 && c >= 0) {
            if(board[r][c] == 1) {
                return false;
            }

            r--;
            c--;
        }

        return true; // true means queen can be placed
    }

    public boolean checkTopRight(int r, int c, int[][] board) {
        while(r >= 0 && c < board.length) {
            if(board[r][c] == 1) {
                return false;
            }

            r--;
            c++;
        }

        return true;
    }
}