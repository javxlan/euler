package leetcode;

import javax.xml.namespace.QName;
import java.util.Arrays;

public class Day1 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,5,2};
        Day1 p = new Day1();
        System.out.println(p.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                result = nums[i];
                break;
            }
            if (nums[i] == nums[i + 1]) {
                i++;
            } else {
                result = nums[i];
                break;
            }
        }
        return result;
    }

}
