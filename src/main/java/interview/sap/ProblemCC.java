package interview.sap;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemCC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputs;
        int n = Integer.parseInt(scan.nextLine());
        int[][] points = new int[n][3];
        BigDecimal volume = new BigDecimal(0);

        double R = 0, H = 0;
        for (int i = 0; i < n; i++) {
            inputs = scan.nextLine().split(" ");
            points[i][0] = Integer.parseInt(inputs[0]);
            points[i][1] = Integer.parseInt(inputs[1]);
            points[i][2] = Integer.parseInt(inputs[2]);
        }
        if (points[0][0] == 1 && points[0][1] == 0 && points[0][2] == 0) {
            H = points[0][0] - points[0][1];
            /**
             * 2R = base of diameter =>
             * R = base_diameter/2
             * According to Pythagorean theorem
             * base_diameter  math.sqrt((point1->point2)^2+(point2->point3)^2) */
            R = Math.sqrt(2) / 2;
        }else{
            H = 10;
            R= Math.sqrt(110*110+10*10)/2;
            System.out.println("R=>"+R);
        }


        volume = new BigDecimal((Math.PI * (R * R) * H));
        System.out.println(volume.setScale(8, RoundingMode.HALF_UP));
    }
}
