package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'getMinimumDifference' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY a
     *  2. STRING_ARRAY b
     */

    public static void main(String[] args) {
        List<String> s1 = new ArrayList<>();
       // s1.add("a");
        //s1.add("jk");
        s1.add("abb");
        s1.add("mn");
        s1.add("abc");

        List<String> s2 = new ArrayList<>();
       // s2.add("bb");
       // s2.add("kj");
        s2.add("bbc");
        s2.add("op");
        s2.add("def");

        System.out.println(getMinimumDifference(s1, s2));
    }

    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).length() == b.get(i).length()) {
                ans.add(countManipulations(a.get(i), b.get(i)));
            } else {
                ans.add(-1);
            }
        }

        return ans;
    }

    static int countManipulations(String s1, String s2)
    {
        int count = 0;

        // store the count of character
        int char_count[] = new int[26];

        // iterate though the first String and update
        // count
        for (int i = 0; i < s1.length(); i++)
            char_count[s1.charAt(i) - 'a']++;

        // iterate through the second string
        // update char_count.
        // if character is not found in char_count
        // then increase count
        for (int i = 0; i < s2.length(); i++)
        {
            char_count[s2.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; ++i)
        {
            if(char_count[i] > 0)
            {
                count+=Math.abs(char_count[i]);
            }
        }

        return count;
    }

}
