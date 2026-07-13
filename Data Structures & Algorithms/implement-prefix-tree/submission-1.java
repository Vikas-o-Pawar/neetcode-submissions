class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        int n = word.length();

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

        boolean wordFound = false;
        TrieNode temp = root;

        for(int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if(temp.children[c - 'a'] == null) {
                return false;
            }

            temp = temp.children[c - 'a'];

            if(i == n - 1 && !temp.isWord) return false;
        }

        return true;
    }
    
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode temp = root;

        for(int i = 0; i < n; i++) {
            char c = prefix.charAt(i);

            if(temp.children[c - 'a'] == null) return false;  

            temp = temp.children[c - 'a'];          
        }

        return true;
    }

    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */