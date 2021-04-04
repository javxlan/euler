package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RemoveDuplicate {


    public static void main(String[] args) {

        int[] array = {0, 9, 7, 10, 12, 45, 54, 1, 1, 1, 0, 0, 0, 0, 0, 4, 5, 5, 4, 5, 6, 7, 7, 8, 5};
        ArrayList<Integer> uniq = new ArrayList<Integer>();
        RemoveDuplicate r = new RemoveDuplicate();


        for (int i = 0; i < array.length; i++) {
            uniq = r.removeDuplicate(array[i], uniq);
        }
        System.out.println(uniq);
    }

    public ArrayList removeDuplicate(int search, ArrayList array) {
        // binary search must be ordered
        int index = Collections.binarySearch(array, search);
        if (index < 0) {
            array.add(search);
            Collections.sort(array);
        }
        System.out.println("search value: " + search + " index  " + index + "  ==>  " + array);
        return array;
    }
}
