package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {

    public static void main(String[] args){

        int[] coins = {1, 5, 10, 25};
        int sum = 66;

        CoinChange m = new CoinChange();
        System.out.println("At least " + m.coinChangeProblem(coins, sum)
                + " coins are required to make a value of " + sum);
    }

    int coinChangeProblem(int[] coins, int sum){

        int totalCoins = coins.length;

        // Creating array which stores subproblems' solutions
        double[][] arr = new double[totalCoins + 1][sum + 1];

        // Initialising first row with +ve infinity
        for(int j = 0; j <= sum; j++){
            arr[0][j] = Double.POSITIVE_INFINITY;
        }

        // Initialising first column with 0
        for(int i = 1; i <= totalCoins; i++){
            arr[i][0] = 0;
        }

        // Implementing the recursive solution
        for(int i = 1; i <= totalCoins; i++){
            for(int j = 1; j <= sum; j++){
                if(coins[i - 1] <= j)
                    arr[i][j] = min(1 + arr[i][j - coins[i - 1]], arr[i - 1][j]);
                else
                    arr[i][j] = arr[i - 1][j];
            }
        }

        for (double[] a : arr){
            System.out.println(Arrays.toString(a));
        }

        return (int)arr[totalCoins][sum];
    }

    // Helper function for the recursive solution.
    double min(double a, double b){
        if(a <= b){
            return a;
        }
        else{
            return b;
        }
    }

}
