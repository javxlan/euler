package leetcode.may;

class Trie {

    String[] child = new String[26];
    String node = null;

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
        String search = "";
        for (char c : str) {
            search += String.valueOf(c);
            if (!startsWith(search)) {
                this.node = String.valueOf(c);
            }
        }
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
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */