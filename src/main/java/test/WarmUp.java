package test;

import java.util.Arrays;

public class WarmUp {

    public static void main(String[] args) {
        int[] Dummy = new int[8];
        for (int i = 0; i < Dummy.length; i++) {
            Dummy[i] = (int) (Math.random() * 100);
        }
        // array to string
        System.out.println(Arrays.toString(Dummy));

        // array sort ascending
        Arrays.sort(Dummy);
        System.out.println(Arrays.toString(Dummy));

        // dummy string array
        String[] array = new String[]{"John", "Mary", "Bob"};
        System.out.println(Arrays.toString(array));

        // string array sort
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        // deep level array
        String[][] deepArray = new String[][]{{"John", "Mary"}, {"Alice", "Bob"}};
        //deep level array to string
        System.out.println(Arrays.deepToString(deepArray));


        // dummy initiated array
        int intArr[] = {10, 20, 15, 22, 35};
        //search array
        int index = Arrays.binarySearch(intArr, 22);
        System.out.println(index);
    }
    
}
