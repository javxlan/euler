package test;

import java.util.HashMap;
import java.util.Map;

public class TrieString {

    public static void main(String[] args) {
        String test = "abcd";
        TrieString t = new TrieString();

        char[] word = test.toCharArray();
        TrieNode root = new TrieNode();


        t.printTrie(t.insertTrie(0, word, root));


    }

    private void printTrie(TrieNode node) {
        if (node.children == null) return;
        printTrie((TrieNode) node.children);
    }

    private TrieNode insertTrie(int index, char[] word, TrieNode node) {
        if (index == word.length - 1) return node;
        node.children.put(word[index], new TrieNode());
        insertTrie(index + 1, word, node);
        return node;
    }

    public boolean search(String word) {
        return false;
    }

    public boolean startWith(String prefix) {
        return false;
    }

    public static class TrieNode {

        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

}


