package test;

import java.util.*;

public class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public static void main(String[] args) {

        PrefixTree p = new PrefixTree();
        char alphabet[] = {'a', 'b', 't'};
        List<String> words = new ArrayList<>();

        words.add("bolor");
        words.add("duran");
        words.add("bat");
        words.add("ka");
        words.add("hurandaa");

        // ordering words
        Collections.sort(words, Comparator.comparing(String::length));
        // reversing order
        Collections.reverse(words);

        //words.forEach(System.out::println);

        for (String word : words) {
            if (p.insert(word, alphabet)) {
                System.out.println("Maximum point word is :" + word);
                break;
            }
        }

        System.out.println("There is nothing matched");
    }

    public boolean insert(String word, char[] alphabet) {
        TrieNode node = root;
        node.is_end = true;
        char[] temp = alphabet;

        for (Character c : word.toCharArray()) {
            int index = findIndexChar(c, temp);
            System.out.println(c + " " + index);
            if (index >= 0) {
                // setting used
                temp[index] = '0';
                int u = c - 'a';
                if (node.child[u] == null) node.child[u] = new TrieNode();
                // just setting to next current node
                node = node.child[u];
            } else {
                node.is_end = false;
                break;
            }
        }
        return node.is_end;
    }

    private int findIndexChar(char c, char[] alphabet) {
        int index = -1;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) {
                index = i;
                break;
            }
        }
        return index;
    }


}
