import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray me = new MergeSortedArray();
        int nums1[] = {1, 2, 3, 4, 0, 0, 0, 0};
        int nums2[] = {2, 5, 6};

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        me.merge(nums1, nums2);

    }


    public void merge(int[] nums1, int[] nums2) {
        int[] dummy = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                dummy[k] = nums1[i];
                i++;
            } else {
                dummy[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < nums1.length) {
            dummy[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length) {
            dummy[k] = nums2[j];
            j++;
            k++;
        }


        System.out.println(Arrays.toString(dummy));
    }
}
