package leetcode.may;

public class RemovekDigits {

    public static void main(String[] args) {
        System.out.println(new RemovekDigits().removeKdigits("10", 2));
    }

    public String removeKdigits(String num, int k) {
        int min = Integer.parseInt(num);
        char[] number = num.toCharArray();
        //brute force approach
        // generate all numbers combinations
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < number.length; j++) {
                min = Math.min(buildNumber(i, j, number), min);
            }
        }
        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int l = j + 1; l < number.length; l++) {
                    min = Math.min(buildNumber(i, j, number), min);
                }
            }
        }

        // iterate them find min
        // return min

        return "" + min;
    }

    public int buildNumber(int i, int j, char[] num) {
        String number = "";
        for (int l = 0; l < num.length; l++) {
            if (l != i && l != j) number += num[l];
        }
        return Integer.parseInt(number);
    }
}
