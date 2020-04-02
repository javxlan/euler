package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Day2 {


    public static void main(String[] args) {
        Day2 p = new Day2();
        System.out.println(p.isHappy(3));
    }

    public boolean isHappy(int n) {
        if (n == 1) return true;  // happy number case
        if (n == 4) return false; // unhappy number case
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
