package interview.sap;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = "Abracadabra";
        int count = scan.nextInt();
        printMagic(count,word);
    }

    public static void printMagic(int n,String word){
        for(int i=1;i<=n;i++){
            System.out.println(i+" "+ word);
        }
    }
}
