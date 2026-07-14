class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        int n = word.length();
        TrieNode temp = root;

        for(int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if(temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new TrieNode();
            }

            temp = temp.children[c - 'a'];

            if(i == n - 1) temp.isWord = true;
        }

    }
    
    public boolean search(String word) {
        int n = word.length();
        TrieNode temp = root;
        return helper(word, temp, 0);
    }

    public boolean helper(String word, TrieNode temp, int idx) {
        if(temp == null) return false;
        if(idx >= word.length()) {
            return temp.isWord;
        }
        
        boolean res = false;
        char c = word.charAt(idx);

        if(c != '.' && temp.children[c - 'a'] == null) return false;

        if(c == '.') {
            for(int i = 0; i < 26; i++) {
                res = res || helper(word, temp.children[i], idx + 1);
                if(res) return true;
            }
        } else {
            if(temp.children[c - 'a'] == null) return false;
            res = res || helper(word, temp.children[c - 'a'], idx + 1);
        }

        return res;
    }

    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */