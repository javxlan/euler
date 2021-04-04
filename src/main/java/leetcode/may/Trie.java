package leetcode.may;

class Trie {

    TrieNode root;

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
    }


    /**
     * Initialize your data structure here.
     */
    public Trie() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] str = word.toCharArray();
        TrieNode node = root;
        for (char c : str) {
            int u = c - 'a';
            if (root.child[u] == null) root.child[u] = new TrieNode();
            node = node.child[u];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return false;
    }

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;

        public TrieNode() {
            for (int i = 0; i < 26; i++) child[i] = null;
            isEnd = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */