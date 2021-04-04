package leetcode.april;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

  public static void main(String[] args) {
    Day2 p = new Day2();
    System.out.println(p.isHappy(3));
  }

  public boolean isHappy(int n) {
    if (n == 1) {
      return true; // happy number case
    }
    if (n == 4) {
      return false; // unhappy number case
    }
    boolean isHappy = false;
    int sum = 0;

    List<Integer> digits = parseNumber(n);

    for (int digit : digits) {
      sum += digit * digit;
    }
    if (sum != 1) {
      isHappy = isHappy(sum);
    } else {
      isHappy = true;
    }

    return isHappy;
  }

  public List<Integer> parseNumber(int number) {
    List<Integer> digits = new ArrayList<>();
    while (number >= 10) {
      int digit = number % 10;
      digits.add(digit);
      number = number / 10;
    }
    digits.add(number);
    return digits;
  }
}

/**
 * Happy number
 *
 * <p>Write an algorithm to determine if a number is "happy".
 *
 * <p>A happy number is a number defined by the following process: Starting with any positive
 * integer, replace the number by the sum of the squares of its digits, and repeat the process until
 * the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include
 * 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * <p>Example:
 *
 * <p>Input: 19 Output: true Explanation: 12 + 92 = 82 82 + 22 = 68 62 + 82 = 100 12 + 02 + 02 = 1
 */
