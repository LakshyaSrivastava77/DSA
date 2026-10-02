class Trie {

    Trie[] children;
    boolean eow;
    // Trie root = new Trie();

    public Trie() {
        children = new Trie[26];
    }
    
    public void insert(String word) {
        Trie curr = this;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null) {
                Trie newNode = new Trie();
                curr.children[ch-'a'] = newNode;
                curr = curr.children[ch-'a'];
            } else {
                curr = curr.children[ch-'a'];
            }
        }
        curr.eow = true;
    }
    
    public boolean search(String word) {
        Trie curr = this;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null) return false;
            curr = curr.children[ch-'a'];
        }
        return curr.eow;
    }
    
    public boolean startsWith(String prefix) {
        Trie curr = this;
        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            char ch = prefix.charAt(i);
            if (curr.children[ch-'a'] == null) return false;
            curr = curr.children[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */