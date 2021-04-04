package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortKeepIndex {
    public static void main(String[] args) {

        int[] numbers = new int[]{
                1, 5, 23, 21, 31, 44, 3, 3, 6, 9
        };

        List<Nums> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            list.add(new Nums(i, numbers[i]));
        }


        System.out.println("before sort: " + Arrays.toString(numbers));

        list.sort((a1, a2) -> {
            return a1.value - a2.value;
        });
        System.out.println("sorted");
        list.forEach(obj -> {
            System.out.println("index:" + obj.index + ", val: " + numbers[obj.index]);
        });

    }


    public static class Nums {
        int index;
        int value;

        public Nums(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


}
