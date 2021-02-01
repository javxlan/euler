package leetcode.august;

import java.util.*;

public class MapOrder {
    public static void main(String[] args) {
        System.out.println(new MapOrder().frequencySort("aaataattreafe"));
    }

    public String frequencySort(String s) {
        if (s == null || s.length() < 2) return s;
        String ans = "";
        Map<Character, Integer> mp = new HashMap<>();
        List<Character> ls = new ArrayList<>();

        char[] str = s.toCharArray();

        for (char c : str) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        mp.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(x -> {
                    ls.add(x.getKey());
                } );

        for (int i=0;i<ls.size();i++) {
               for(int j=0;j<mp.get(ls.get(i));j++){
                      ans+=String.valueOf(ls.get(i));
             }
        }
        return ans;
    }
}

