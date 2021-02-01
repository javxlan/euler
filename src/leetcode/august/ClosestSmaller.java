package leetcode.august;

import java.util.*;
import java.util.stream.Collectors;

public class ClosestSmaller {


    public static void main(String[] args) {
        //List<Integer> stock = Arrays.asList(5, 6, 8, 4, 9, 10, 8, 3, 6, 4);
        List<Integer> stock = Arrays.asList(5, 6, 8, 4, 9, 10, 8, 3, 6, 4);
        //List<Integer> q = Arrays.asList(6, 5, 4);
        List<Integer> q = Arrays.asList(3, 1, 8);
        System.out.println(predictAnswer(stock, q));

    }


    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
        //List<Integer> ans = new ArrayList<>();
        int[] answer = new int[queries.size()];
        int[] qa = queries.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();
        int[] sa = stockData.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();
        Map<Integer, Integer> mem = new HashMap<>();

        int left, right, min, curIndex;
        for (int i = 0; i < qa.length; i++) {
            curIndex = qa[i] - 1;
            left = curIndex - 1 > 0 ? curIndex - 1 : 0;
            right = curIndex + 1 < sa.length - 1 ? curIndex + 1 : sa.length - 1;
            min = -1;
            if (mem.getOrDefault(curIndex, 0) == 0) {
                while (!(left == 0 && right == sa.length - 1) && min == -1) {
                    if (sa[left] < sa[curIndex]) min = left + 1;
                    if (min == -1 && sa[right] < sa[curIndex]) min = right + 1;
                    if (left > 0) left--;
                    if (right < sa.length - 1) right++;
                }
                //ans.add(min);
                answer[i] = min;
                mem.put(curIndex, min);
            } else {
                answer[i] = mem.get(curIndex);
            }
        }
        return Arrays.stream(answer).boxed().collect(Collectors.toList());
    }
}
