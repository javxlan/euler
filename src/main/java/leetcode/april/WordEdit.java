package leetcode.april;


import java.io.*;
import java.util.*;

class WordEdit {

    static String pos_words[];
    static Set<String> visited;

    static int shortestWordEditPath(String source, String target, String[] words) {
        pos_words = words;
        visited = new HashSet<>();
        Queue<Word> q = new ArrayDeque<>();
        Word src = new Word(source, 0);
        q.add(src);
        visited.add(src.w);
        while (!q.isEmpty()) {
            Word current = q.remove();
            if (current.w.equals(target)) return current.l;
            List<Word> nexts = getNext(current);
            for (Word nextWord : nexts) {
                visited.add(nextWord.w);
                q.add(nextWord);
            }
        }
        return -1;
    }

    static public List<Word> getNext(Word current) {
        List<Word> temp = new ArrayList<>();
        char[] cur = current.w.toCharArray();
        for (String word : pos_words) {
            if (visited.contains(word)) continue;
            int mis = 0;
            char[] str = word.toCharArray();
            for (int i = 0; i < str.length; i++) {
                if (str[i] != cur[i]) mis++;
                if (mis > 1) break;
            }
            if (mis == 1) temp.add(new Word(word, current.l + 1));
        }
        return temp;
    }

    static class Word {
        String w;
        int l;

        public Word(String word, int level) {
            w = word;
            l = level;
        }
    }

    public static void main(String[] args) {
        String[] words = {"but", "put", "big", "pot", "pog", "dog", "lot"};
        String source = "bit";
        String target = "dog";
        System.out.println(new WordEdit().shortestWordEditPath(source, target, words));
    }
}


