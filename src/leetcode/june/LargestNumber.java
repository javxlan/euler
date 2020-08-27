package leetcode.june;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

  public static void main(String[] args) {
    int[] numbers = new int[] {3, 30, 34, 5, 9};
    System.out.println(solution(numbers));
  }

  public static String solution(int[] numbers) {
    String answer = "";
    // init str array
    String[] strArr = new String[numbers.length];
    // fill str array
    for (int i = 0; i < strArr.length; i++) {
        strArr[i]=String.valueOf(numbers[i]);
    }
    // compare between permutations
    Arrays.sort(strArr,(a,b)->{
        String num1=  a+b;
        String num2=  b+a;
        // descending order
        return num2.compareTo(num1);
    });

    // build result
    for (String number: strArr){
        answer+=number;
    }

    return answer;
  }
}

// 9,5,34,3,30
