package test;

class Trie {
    TrieNode root;


    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true

    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (Character c : word.toCharArray()) {
            int u = c - 'a';
            if (node.child[u] == null) node.child[u] = new TrieNode();
            // just setting to next current node
            node = node.child[u];
        }
        node.is_end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (Character c : word.toCharArray()) {
            int u = c - 'a';
            if (node.child[u] == null) return false;
            node = node.child[u];
        }
        return node.is_end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (Character c : prefix.toCharArray()) {
            int u = c - 'a';
            if (node.child[u] == null) return false;
            node = node.child[u];
        }
        return true;
    }
}

class TrieNode {
    boolean is_end;
    TrieNode[] child = new TrieNode[26];

    TrieNode() {
        is_end = false;
        for (int i = 0; i < 26; i++) child[i] = null;
    }
}