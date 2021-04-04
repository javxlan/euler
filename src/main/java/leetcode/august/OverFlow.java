package leetcode.august;

import java.math.BigInteger;
import java.util.*;

public class OverFlow {
    public static void main(String[] args) {
        //System.out.println(new OverFlow().fact(25));
        int[] nums = {3,30,34,5,9};
        System.out.println(new OverFlow().largestNumber(nums));

    }

    public String fact(int n){
        long ans =  1;
        for (int i =1;i<=n;i++)
            ans = ans*i;
        return Long.toString(ans);
    }


    public String largestNumber(int[] nums) {
        String ans = "";
        if(nums == null || nums.length ==0) return "0";
        Arrays.sort(nums);
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            ls.add(String.valueOf(nums[i]));
        }
        Collections.sort(ls, (a,b)->{
            return (b+a).compareTo(a+b);
        });
        if(ls.get(0).equals("0")) return "0";
        for (int i = 0; i < nums.length ; i++) {
            ans+=ls.get(i);
        }
        return ans;
    }
}
