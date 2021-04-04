package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BSTCustom {
    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(62545829, 84190139, 78929704, 93415066, 68100859, 34558506, 8998793, 29425523, 49808805);
        List<Integer> b = Arrays.asList(53450202, 541141, 41977929, 20339497, 48349941, 14771018, 28712344, 87047054, 2680079, 79722615, 2484677);
        List<Integer> c = Arrays.asList(36947172, 72503803, 77158117, 84052166, 14419148, 37664199, 93166144, 61587651, 60891444, 71700514);
        long ans = 0;

        int an = a.size(), bn = b.size(), cn = c.size();
        Collections.sort(a);
        Collections.sort(b);
        Collections.sort(c);
        int numsInA, numsInC, current;
        // iterating b array
        for (int i = 0; i < b.size(); i++) {
            current = b.get(i);
            numsInA = getIndex(a, current);
            // System.out.println(lsB.get(i)+" -> A "+numsInA);
            numsInC = getIndex(c, current);
            // System.out.println(lsB.get(i)+" -> C "+numsInC);
            // System.out.println(numsInC);
            ans += (numsInA * numsInC);
        }
        System.out.println(ans);
        //return ans;
        //return left;
    }

    public static int getIndex(List<Integer> ls, int val) {

        int left = 0;
        int right = ls.size() - 1;
        int mid;
        if (ls.get(left) > val) return 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid - 1 >= 0 && ls.get(mid - 1) <= val && ls.get(mid) > val) {
                return mid;
            }
            if (mid < val) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
