package leetcode.april;

import java.util.*;

public class Day6 {
    public static void main(String[] args) {
        String[] dummy = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Day6().groupAnagrams(dummy));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();
        if (strs.length == 0) return list;
        List<String> root = new ArrayList<>();
        root.add(strs[0]);
        list.add(root);

        for (int i = 1; i < strs.length; i++) {
            list = groupAnagram(strs[i], list);
        }
        return list;
    }

    public List<List<String>> groupAnagram(String str, List<List<String>> list) {
        boolean isMatch = false;
        for (List<String> ls : list) {
            if (isAnagram(ls.get(0), str)) {
                ls.add(str);
                isMatch = true;
                break;
            }
        }
        if (!isMatch) {
            List<String> newList = new ArrayList<>();
            newList.add(str);
            list.add(newList);
        }
        return list;
    }

    public boolean isAnagram(String raw, String str) {
        char rawArray[] = raw.toCharArray();
        char strArray[] = str.toCharArray();
        Arrays.sort(rawArray);
        Arrays.sort(strArray);
        return Arrays.equals(rawArray, strArray);
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
 * <p>
 * <p>
 * <p>
          public List<List<String>> groupAnagrams(String[] strs) {
          List<List<String>> result = new ArrayList<List<String>>();
              HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
              for(String str: strs){
              char[] arr = new char[26];
              for(int i=0; i<str.length(); i++){
              arr[str.charAt(i)-'a']++;
              }
              String ns = new String(arr);
              if(map.containsKey(ns)){
              map.get(ns).add(str);
              }else{
              ArrayList<String> al = new ArrayList<String>();
              al.add(str);
              map.put(ns, al);
              }
              }
              result.addAll(map.values());
          return result;
         }
 */


/**
 *
 *
 *  public List<List<String>> groupAnagrams(String[] strs) {
 *         List<List<String>> result = new ArrayList<List<String>>();
 * HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
 * for(String str: strs){
 * char[] arr = new char[26];
 * for(int i=0; i<str.length(); i++){
 * arr[str.charAt(i)-'a']++;
 * }
 * String ns = new String(arr);
 * if(map.containsKey(ns)){
 * map.get(ns).add(str);
 * }else{
 * ArrayList<String> al = new ArrayList<String>();
 * al.add(str);
 * map.put(ns, al);
 * }
 * }
 * result.addAll(map.values());
 * return result;
 *     }
 */
