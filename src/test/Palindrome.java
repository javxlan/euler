package test;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome("abccba"));

        // String 



    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] text = s.toCharArray();
        boolean even = false;
        if (text.length % 2 == 0) {
            even = true;
        }

        int del = text.length / 2;
        for (int i = 0; i < del; i++) {
            if (Character.isLetter(text[i]) || Character.isDigit(text[i]))
                sb.append(Character.toLowerCase(text[i]));
        }
        System.out.println(sb.toString());

        String last = even ? s.substring(del, text.length) : s.substring(del + 1, text.length);

        System.out.println(last);
        if (sb.reverse().toString().equals(last))
            return true;
        else
            return false;
    }
}
