package leetcode.july;

import java.util.HashSet;

public class PrimePermute {

    public HashSet<Integer> poss;

    public PrimePermute() {
        this.poss = new HashSet<>();
    }

    public static void main(String[] args) {
        // Time complexity   O(N*N!)
        // Space  complexity  O(N*N!)
        System.out.println(new PrimePermute().solution("173"));
    }

    public int solution(String numbers) {
        int answer = 0;

        //build numbers into array

        //for (int i = 1; i <= numbers.length(); i++) {
            //generatePermutation(numbers.substring(0,i), 0, i);
               generatePermutation(numbers, 0, numbers.length());
        //}

        for (int number : this.poss) {
            if (isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }

    public void generatePermutation(String str, int start, int end) {
        //Prints the permutations
        if (start == end - 1) {
            this.poss.add(Integer.parseInt(str));
        } else {
            for (int i = start; i < end; i++) {
                //Swapping the string by fixing a character
                str = swapString(str, start, i);
                System.out.println(str+ " "+start+" "+end);
                //Recursively calling function generatePermutation() for rest of the characters
                generatePermutation(str, start + 1, end);
                //Backtracking and swapping the characters again.
                str = swapString(str, start, i);
            }
        }
    }

    public String swapString(String a, int i, int j) {
        char[] b = a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;
        //Converting characters from array into single string
        return String.valueOf(b);
    }


    public boolean isPrime(int num) {
        int i = 2;
        if(num<2) return false;
        boolean result = true;

        while (i <= num / 2) {
            // condition for nonprime number
            if (num % i == 0) {
                result = false;
                break;
            }

            ++i;
        }
        return result;
    }
}
