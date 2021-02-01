package leetcode.august;

import java.util.Random;
import java.util.Scanner;

public class SampleGenerator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rn = new Random();


        System.out.println("Хэдэн бодлого бодох вэ?");
        int num = scan.nextInt();
        System.out.println("Хэдэн оронтой тоо бодмоор байна ?");
        double digits = scan.nextInt();
        int min, max;

        min = (int) Math.pow(10, digits - 1);
        max = (int) Math.pow(10, digits) - 1;

        int[][] samples = new int[num][2];

        for (int i = 0; i < num; i++) {
            int a = rn.nextInt(max - min) + min;
            int b = rn.nextInt(max - min) + min;
            samples[i][0] = a;
            samples[i][1] = b;

            System.out.println("*************   Бодлого - " + (i + 1) + "     **********");

            System.out.println(" "+a);
            System.out.println("+");
            System.out.println(" "+b);
            int ans = scan.nextInt();
            if (ans == a + b) System.out.println("Баяр хүргэе зөв байна");
            else System.out.println("зөв хариу бол " + (a + b));
            System.out.println("");
            System.out.println("");
        }
        scan.close();
    }
}
