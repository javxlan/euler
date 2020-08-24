package leetcode.july;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    List<String> permutes;

    public static void main(String[] args) {
        String s = "ABC";
        //this.permutes = new ArrayList<>();
        printPermutn(s, "");

    }

    static void printPermutn(String str, String ans) {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + "\n");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // i-th character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);
            System.out.println(ch+" :"+ros);
            // Recurvise call
            printPermutn(ros, ans + ch);
        }
    }
}
