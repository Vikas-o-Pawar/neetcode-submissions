class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                boolean res = dfs(0, word, board, r, c, m, n);

                if(res) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int ind, String word, char[][] board, int r, int c, int m, int n) {
        if(ind == word.length()) {
            return true;
        }

        if(!isValid(r, c, m, n)) {
            return false;
        }

        if(board[r][c] == ' ') {
            return false;
        }

        // we have an int ind that checks the character at an index in the word string.        
        // current char
        char currCellChar = board[r][c];
        board[r][c] = ' ';

        if(currCellChar == word.charAt(ind)) {
            // a character has matched check next possibilites

            // we can construct string by going either up, down, left or right;
            // ind + 1 check next index in the word string.

            boolean up = dfs(ind + 1, word, board, r - 1, c, m, n);

            if(up) {
                return true;
            }

            boolean down = dfs(ind + 1, word, board, r + 1, c, m, n);

            if(down) {
                return true;
            }

            boolean left = dfs(ind + 1, word, board, r, c - 1, m, n);

            if(left) {
                return true;
            }

            boolean right = dfs(ind + 1, word, board, r, c + 1, m, n);

            if(right) {
                return true;
            }

            
        }

        board[r][c] = currCellChar;

        return false;
    }

    public boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m && c >= 0 && c < n);
    }
}