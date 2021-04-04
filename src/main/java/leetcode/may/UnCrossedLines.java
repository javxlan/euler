package leetcode.may;

public class UnCrossedLines {
  public static void main(String[] args) {
    int[] A = {1, 4, 2}, B = {1, 2, 4};
    System.out.println(new UnCrossedLines().maxUncrossedLines(A, B));
  }

  public int maxUncrossedLines(int[] A, int[] B) {
    int count = 0;
    int stop = 0;
    for (int value : A) {

      int index = find(B, stop, value);
      if (index >= 0) {
        count++;
        stop = index + 1;
      }
    }
    return count;
  }

  public int find(int[] B, int start, int search) {
    int isFound = -1;
    for (int i = start; i < B.length; i++) {
      if (search == B[i]) {
        isFound = i;
        break;
      }
    }
    return isFound;
  }
}
