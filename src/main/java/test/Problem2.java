package test;

import java.util.*;

public class Problem2 {
    public static void main(String[] args) {

        List<Character> str = new ArrayList<>();
        str.add('a');
        str.add('b');
        str.add('a');
        str.add('b');
        str.add('c');
        str.add('b');
        str.add('a');
        str.add('c');
        str.add('a');
        str.add('d');
        str.add('e');
        str.add('f');
        str.add('e');
        str.add('g');
        str.add('d');
        str.add('e');
        str.add('h');
        str.add('i');
        str.add('j');
        str.add('h');
        str.add('k');
        str.add('l');
        str.add('i');
        str.add('j');


          //[a, b, a, b, c, b, a, c, a, d, e, f, e, g, d, e, h, i, j, h, k, l, i, j]

        System.out.println(new Problem2().lengthEachScene(str));
    }


    List<Integer> lengthEachScene(List<Character> inputList)
    {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> m = new HashMap<>();



        for (int i = 0; i < inputList.size(); i++)
        {
            //System.out.println(inputList.get(i));
            m.put(inputList.get(i),i);
        }


        int left = 0;
        int right = 0;
        for (int i = 0; i < inputList.size(); i++)
        {
            right = Math.max(right, m.get(inputList.get(i)));
            if (right == i)
            {
                result.add(1 + right - left);
                left = right + 1;
            }
        }
        return result;
    }
}
