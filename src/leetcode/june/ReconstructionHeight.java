package leetcode.june;

import java.util.Arrays;

public class ReconstructionHeight {

  public static void main(String[] args) {
    int[][] people = new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    System.out.println("**** before *****");
    print(people);
    reconstructQueue(people);
  }

  // Output:
  // [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
  public static int[][] reconstructQueue(int[][] people) {
    Arrays.sort(
        people,
        (a, b) -> {
          return (a[0]-b[0]);
        });
    System.out.println("**** sorted *****");
    print(people);
    return people;
  }

  public static void print(int[][] people) {
    Arrays.asList(people)
        .forEach(
            p -> {
              System.out.println(p[0] + "," + p[1]);
            });
  }
}
