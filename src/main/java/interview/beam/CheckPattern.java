package interview.beam;

import java.util.Arrays;
import java.util.Collections;

/**
 * Find out if any permutation of a pattern is present in a source string -
 * e.g "eced"in "abcdeefghij"should return true,but "cdfg"should return false. Both string and pattern will consist of lower case ascii characters.
 * function
 */

public class CheckPattern {

    public static void main(String[] args) {
        String pattern = "ab";
        String source = "eidboaoo";
        System.out.println(isPermute(pattern, source));
    }

    public static boolean isPermute(String pattern, String source) {
        char[] pat = pattern.toCharArray();
        Arrays.sort(pat);

        char[] src = source.toCharArray();
        int srcSize = src.length;
        int n = pat.length;

        for (int i = 0; i < srcSize - pat.length; i++) {
            if (check(i, i + n - 1, src, pat)) {
                return true;
            }
        }

        return false;
    }

    // abcdeefghij
// eced
// sort(abcd) == sort(eced)
//
    public static boolean check(int start, int end, char[] src, char[] pat) {
        String temp = "";
        for (int i = start; i < end; i++) {
            temp += String.valueOf(src[i]);
        }
        char[] tempRange = temp.toCharArray();
        Arrays.sort(tempRange);

        // sort(abcd) == sort(eced)
        for (int i = 0; i < tempRange.length; i++) {
            if (pat[i] != tempRange[i]) return false;
        }
        return true;
    }

// test

// src[] = abcdeefghij
// pat[] = eced
// sort(pat), pat=eecd

// i=0,3, abcdeefghij , eecd
// temp = abcd
// tempRange = abcd, sort
// abcd == eecd

}
