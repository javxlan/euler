package leetcode.april;

public class Day4 {
    public static void main(String[] args) {
        int[] dummy = new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        new Day4().moveZeroes(dummy);
    }

    public void moveZeroes(int[] nums) {
        int size = nums.length - 1;
        if (size != 0) {

            int pointerOne = 0;
            int pointerTwo = 1;

            /** out of while condition */
            while (pointerOne <= size && pointerTwo <= size) {

                /** when both of them equal to 0 then skip to the next */
                if (nums[pointerOne] != 0 && nums[pointerTwo] != 0) {
                    pointerOne++;
                    pointerTwo++;
                } else {
                    /** when pointerOne is = 0 it's find the swap target pointerTwo */
                    if (nums[pointerOne] == 0) {
                        if (nums[pointerTwo] != 0) {
                            /** when one of them is 0 and another one is not then it's able to swap these elements */
                            int swap = nums[pointerTwo];
                            nums[pointerTwo] = nums[pointerOne];
                            nums[pointerOne] = swap;
                            /** swapped after increasing the loop number  */
                            pointerOne++;
                            pointerTwo++;
                        } else {
                            /** when */
                            pointerTwo++;
                        }
                    } else {
                        pointerOne++;
                    }
                }
            }
        }
    }
}



/**
 *
 * Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
