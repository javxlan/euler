package leetcode.august;

public class Permutation {

    public static void main(String args[]) {
        permutation("ABC");
    }

    /*
     * A method exposed to client to calculate permutation of String in Java.
     */
    public static void permutation(String input){
        permutation("", input);
    }

    /*
     * Recursive method which actually prints all permutations
     * of given String, but since we are passing an empty String
     * as current permutation to start with,
     * I have made this method private and didn't exposed it to client.
     */
    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.out.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++){
                 String a = perm+word.charAt(i);
                 String b = word.substring(0, i) + word.substring(i + 1, word.length());
                 permutation(a, b);
            }
        }
    }
}
