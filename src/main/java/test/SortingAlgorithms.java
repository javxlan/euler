package test;

import java.util.Arrays;

public class SortingAlgorithms {

    public static void main(String[] args) {

        int[] arr = {6, 2, 5, 3, 4, 6, 44, 34};

        var sort = new SortingAlgorithms();
        //sort.insertionSort(arr);

        sort.mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }

    /**
     * Time complexity:  O(N^2)
     */
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];

            // previous index
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = current;
        }
    }

    /**
     * Time complexity:  O( N*Log(N))
     */
    /* l is for left index and r is right index of the
   sub-array of arr to be sorted */
    public void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}


// 8 , 4 , 1 ,5, 10
//  8>4  ,   8,1,5,10
