package leetcode.august;

public class LoopBreak {
  public static void main(String[] args) {
    new LoopBreak().test();
  }

  public void test() {

    boolean found = false;
    for (int i = 0; i < 1000 && !found; i++) {
      for (int j = 0; j < 1000 && !found; j++) {
        if (j == 200) {
          System.out.println(i + " of " + j);
          found = true;
        }
      }
    }
  }
}
