package leetcode;

import java.util.*;

public class Day6 {
    public static void main(String[] args) {
        String[] dummy = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Day6().groupAnagrams(dummy));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();

        List<String> ordered = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            ordered.add(orderTo(strs[i]));
        }

        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i] + ordered.contains(orderTo(strs[i])));
        }

        return list;
    }



    public String orderTo(String raw) {
        char tempArray[] = raw.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
/**
 * Group Anagrams
 * Given an array of strings, group anagrams together.
 * Sample
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */