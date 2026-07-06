class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // top row
        for(int i = 0; i < n; i++) {
            if(board[0][i] == 'O') {
                dfs(board, m, n, 0, i, board[0][i]);
            }
        }

        // bottom
        for(int i = 0; i < n; i++) {
            if(board[m - 1][i] == 'O') {
                dfs(board, m, n, m - 1, i, board[m - 1][i]);
            }
        }

        // left col
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                dfs(board, m, n, i, 0, board[i][0]);
            }
        }

        // right col
        for(int i = 0; i < m; i++) {
            if(board[i][n - 1] == 'O') {
                dfs(board, m, n, i, n - 1, board[i][n - 1]);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = (board[i][j] == 'Y') ? 'O': 'X';
            }
        }
    }

    public void dfs(char[][] board, int m, int n, int r, int c, char prevChar) {
        if(!isValid(m, n, r, c)) {
            return;
        }
        
        if(board[r][c] == 'Y' || board[r][c] == 'X') {
            return;
            // Y is visited and X means we are never meant to traverse it.
        }

        char temp = board[r][c];
        board[r][c] = 'Y';

        dfs(board, m, n, r - 1, c, temp);

        dfs(board, m, n, r + 1, c, temp);

        dfs(board, m, n, r, c - 1, temp);

        dfs(board, m, n, r, c + 1, temp);
    }

    public boolean isValid(int m, int n, int r, int c) {
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }
}
