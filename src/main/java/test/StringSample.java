package test;

import java.util.ArrayList;
import java.util.List;

public class StringSample {


    public static void main(String[] args) {
        StringSample s = new StringSample();

        System.out.println(s.letterCasePermutation("a1b2"));
    }


    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if(S == null || S.isEmpty()) { return result; }

        letterCasePermutationUtil(0, S.toCharArray(), result);
        return result;
    }


    private void letterCasePermutationUtil(int index, char []original, List<String> result) {
        if(index == original.length) {
            result.add(new String(original));
            return;
        }

        System.out.println(index);
        letterCasePermutationUtil(index + 1, original, result);
        char ch = original[index];
        if(!isDigit(ch)) {
            if(ch >= 'a') {
                original[index] = (char)(ch - 32);
            } else {
                original[index] = (char)(ch + 32);
            }
            letterCasePermutationUtil(index + 1, original, result);
            original[index] = ch;
        }
    }

    boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
