class Solution {
    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        for(String word: words) {
            add(word, root);
        }
        
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, root, i, j, m, n, res);
            }
        }

        return res;        
    }

    public void dfs(char[][] board, TrieNode temp, int r, int c, int m, int n, List<String> res) {
        if(!isValid(r, c, m, n) || board[r][c] == ' ') {
            return;
        }

        char cellChar = board[r][c];

        if(temp.children[cellChar - 'a'] == null) {
            return;
        }

        temp = temp.children[cellChar - 'a'];

        if(temp.word != null) {
            res.add(temp.word);
            temp.word = null;
        }

        board[r][c] = ' ';
       
        dfs(board, temp, r - 1, c, m, n, res);
        dfs(board, temp, r + 1, c, m, n, res);
        dfs(board, temp, r, c - 1, m, n, res);
        dfs(board, temp, r, c + 1, m, n, res);

        board[r][c] = cellChar;

        return;
    }

    public boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }

    public void add(String word, TrieNode root) {
        TrieNode temp = root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new TrieNode();
            }

            temp = temp.children[c - 'a'];
        }

        temp.word = word;
    }

    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}