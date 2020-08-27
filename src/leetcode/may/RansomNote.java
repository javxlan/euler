package leetcode.may;

public class RansomNote {

  public static void main(String[] args) {
    System.out.println(new RansomNote().canConstruct("aa", "aab"));
  }

  public boolean canConstruct(String ransomNote, String magazine) {

    char[] chars = ransomNote.toCharArray();
    int total = 0;
    for (char c : chars) {
      int i = magazine.indexOf(c);
      if (i >= 0) {
        magazine = magazine.substring(0, i) + magazine.substring(i + 1, magazine.length());
        total++;
      }
    }
    return total == ransomNote.length();
  }
}
