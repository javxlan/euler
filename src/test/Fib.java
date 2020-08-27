package test;

import com.sun.source.tree.Tree;

import java.util.*;

public class Fib {

  public static void main(String[] args) {

    // [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]

    int[][] costs =
        new int[][] {
          {10, 20}, {30, 200},
          {400, 50}, {30, 20},
          // {840, 118}, {577, 469}
        };

    int min = 0, cityA = 0, cityB = 0, N = costs.length / 2;
    Map<Integer, Integer> treeMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < 2 * N; i++) {
      int val = costs[i][0] - costs[i][1];
      val = val < 0 ? val * -1 : val;
      System.out.println(val + " " + i);
      treeMap.put(val,i);
    }



    Set set = treeMap.entrySet();
    Iterator i = set.iterator();
    System.out.println("'''''''''''''''''''''''''''''''");
    while (i.hasNext()) {
      Map.Entry<Integer, Integer> me = (Map.Entry) i.next();
      System.out.println(me.getKey() + " " + me.getValue());

      if (cityA == N || cityB == N) {
        if (cityA == N) {
          cityB++;
          min += costs[me.getValue()][1];
        } else {
          cityA++;
          min += costs[me.getValue()][0];
        }
      } else {
        if (costs[me.getValue()][0] < costs[me.getValue()][1]) {
          cityA++;
          min += costs[me.getValue()][0];
        } else {
          cityB++;
          min += costs[me.getValue()][1];
        }
      }
    }
    System.out.println(min);
  }
}
