package leetcode.august;

import java.util.ArrayList;
import java.util.List;

public class Staircase {
  public static void main(String[] args) {
    //
    new Staircase().solve(12);
  }

  public List<Integer> solve(int steps) {
    int step1 = 1;
    int step2 = 2;
    int step3 = 3;

    List<Integer> ans = new ArrayList<>();

    for (int i = step1; i < steps; i++) {
        ans.add(i);
    }

    return ans;
  }
}
