package dome;

import java.util.Arrays;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {

//        int left = 0;
//        int right = sortedArray.length - 1;
//        int mid = left + (right - left) / 2;
//        while (left < right) {
//            mid = left + (right - left) / 2;
//            if (sortedArray[mid] <= lessThan && sortedArray[mid + 1] > lessThan) return mid;
//            if (sortedArray[mid] > lessThan) right = mid;
//            else left = mid;
//        }
//        return mid;

        int upBound = Arrays.binarySearch(sortedArray, lessThan);
        System.out.println(upBound);
        if (upBound >= 0) return upBound ;
        else return -upBound - 1;

        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[]{1, 3, 5, 7,20}, 18));
    }
}
