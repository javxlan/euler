package test;

import java.util.Arrays;

public class Dynamic {


    public static void main(String[] args) {
        Dynamic d = new Dynamic();
        int[] data = new int[]{-1, 1, 1, 1, 2, 1};
        System.out.println(d.majorityElement(data));
    }


    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        int[] arr = nums;
        int major = arr[0];
        int counter = 1;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == major) {
                counter++;
                if (counter > (arr.length / 2)) {
                    break;
                }
            } else {
                major = arr[i];
                counter = 1;
            }

        }
        return major;
    }
}
