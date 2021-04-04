package leetcode.august;

import java.util.*;
import java.util.stream.Collectors;

public class BusStand {

    public static void main(String[] args) {
        int k = 2;
        int lastIndex = 0;
        List<Integer> p = Arrays.asList(28485, 99776, 3689, 26679, 60958, 97664, 50269, 41105, 5148, 3306);
        //List<Integer> p = Arrays.asList(1, 4, 4, 3, 1, 2, 6);
        List<Integer> q = Arrays.asList(45321, 38339, 76251, 40751, 7660, 43315, 7094, 34886, 31812, 69909, 41506, 12542, 21648, 96747, 2692);
        //List<Integer> q = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        //System.out.println(q.toString());
        System.out.println(new BusStand().kthPerson(k, p, q));
    }

    public List<Integer> kthPerson(int k, List<Integer> p, List<Integer> q) {

        //List<Integer> answer = new ArrayList<>();
        int[] answer = new int[q.size()];
        int[] qa = q.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();

        int[] pa = p.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();


        int qs = qa.length;
        //int qs = qo.size();
        int ps = pa.length;
        boolean lastZero = false;
        int last = Integer.MAX_VALUE;
        Map<Integer, Integer> mem = new HashMap<>();

        for (int i = 0; i < qs; i++) {
            //int qt = q.get(i);
            int qt = qa[i];
            //Pair qt = qo.get(i);
            if (qt < 1 || qt > last && lastZero) {
                //answer.add(0);
                //answer[qt.index] = 0;
                answer[i] = 0;
            } else {
                if (mem.getOrDefault(qt, 0) == 0) {
                    int ct = 0;
                    for (int j = 0; j < ps; j++) {
                        //if (qt <= p.get(j)) {
                        if (qt <= pa[j]) {
                            ct++;
                            if (ct == k) {
                                mem.put(qt, j + 1);
                                //answer.add(j + 1);
                                //answer[qt.index] = j + 1;
                                answer[i] = j + 1;
                                break;
                            }
                        }
                    }
                    if (ct < k) {
                        //answer.add(0);
                        //answer[qt.index] = 0;
                        answer[i] = 0;
                        lastZero = true;
                        last = qt;
                    }
                } else {
                    //answer.add(mem.get(qt));
                    //answer[qt.index] = mem.get(qt.value);
                    answer[i] = mem.get(qt);
                }
            }
        }
        return Arrays.stream(answer).boxed().collect(Collectors.toList());
    }

}
