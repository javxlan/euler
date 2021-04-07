package test;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 9, 1, 0, -6};
        int[] temp = new int[arr.length];

        MergeSort m = new MergeSort();
        m.mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;

        mergeSort(arr, temp, left, middle);
        mergeSort(arr, temp, middle + 1, right);
        mergeHalves(arr, temp, left, right);
    }

    private void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int index = leftStart;
        int size = rightEnd - leftStart + 1;
        int left = leftStart;
        int right = rightStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] < arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }
        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }
}
