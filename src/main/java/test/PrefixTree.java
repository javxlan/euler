package test;

import java.util.*;

public class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public static void main(String[] args) {

        PrefixTree p = new PrefixTree();
        char alphabet[] = {'a', 'b', 'e', 'p', 'p', 'l', 'o', 'r'};
        List<String> words = new ArrayList<>();

        words.add("air");
        words.add("app");
        words.add("ap");
        words.add("orange");
        words.add("apple");

        // ordering words
        Collections.sort(words, Comparator.comparing(String::length));
        // reversing order
        Collections.reverse(words);

        //words.forEach(System.out::println);
        boolean isFound = false;

        for (String word : words) {
            if (p.insert(word, alphabet)) {
                System.out.println("Maximum point word is :" + word);
                isFound = true;
                break;
            }
        }

        if (!isFound) System.out.println("There is nothing matched");
    }

    public boolean insert(String word, char[] alphabet) {
        //TrieNode node = root;
        boolean isMatched = true;

        char[] temp = Arrays.copyOf(alphabet, alphabet.length);

        for (Character c : word.toCharArray()) {
            int index = findIndexChar(c, temp);
            if (index >= 0) {
                // setting used
                temp[index] = '0';
                //int u = c - 'a';
                //if (node.child[u] == null) node.child[u] = new TrieNode();
                // just setting to next current node
                //node = node.child[u];
            } else {
                isMatched = false;
                break;
            }
        }
        return isMatched;
    }

    private int findIndexChar(char c, char[] temp) {
        int index = -1;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == c) {
                index = i;
                break;
            }
        }
        return index;
    }


}
