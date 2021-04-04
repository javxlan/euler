package hackerrank;

import java.text.Format;
import java.util.*;

/**
 * Date 08/12/2013
 * @author Tushar Roy
 *
 * Given a total and coins of certain denomination with infinite supply, what is the minimum number
 * of coins it takes to form this total.
 *
 * Time complexity - O(coins.size * total)
 * Space complexity - O(coins.size * total)
 *
 * Youtube video -
 * Topdown DP - https://youtu.be/Kf_M7RdHr1M
 * Bottom up DP - https://youtu.be/Y0ZqKpToTic
 */
public class CoinChangingMinimumCoin {


    public int[] minimumCoinBottomUp(int total, int coins[]){

        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for(int i=1; i <= total; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        for(int j=0; j < coins.length; j++){
            for(int i=1; i <= total; i++){
                if(i >= coins[j]){
                    if (T[i - coins[j]] + 1 < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans = printCoinCombination(R, coins);

        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }

    private List<Integer> printCoinCombination(int R[], int coins[]) {

        List<Integer> ans = new ArrayList<>();
        int start = R.length - 1;
        while ( start != 0 ) {
            int j = R[start];
            ans.add(coins[j]);
            start = start - coins[j];
        }
        return ans;
    }

    public static void main ( String args[] ) {
        int total = 66;
        int coins[] = {1, 5, 10, 25};
        CoinChangingMinimumCoin cc = new CoinChangingMinimumCoin();
        Map<Integer, Integer> map = new HashMap<>();

        System.out.println(Arrays.toString(cc.minimumCoinBottomUp(total, coins)));

    }


}
