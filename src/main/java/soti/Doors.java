package soti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Puzzle: There are 100 doors initially closed and 100 people. 1st person opens all doors,
 * 2nd person toggles all 2 multiple doors,
 * 3rd person toggles all 3 multiple doors and so on.
 * After the 100th person, which doors remains open?
 */
public class Doors {
    public static void main(String[] args) {

        int N = 1000000;
        // false = closed, true = open;
        boolean[] doors = new boolean[N + 1];
        //System.out.println(Arrays.toString(doors));
        for (int person = 1; person <= N; person++) {
            toggle(doors, person, N);
            //System.out.println("person:" + person + " " + Arrays.toString(doors));
        }
        List<Integer> ans = new ArrayList<>();

        for (int door = 1; door <= N; door++) {
            if (doors[door]) ans.add(door);
        }
        // System.out.println(ans.toString());
    }

    public static void toggle(boolean[] doors, int person, int N) {

        for (int step = 1; step * person <= N; step++) {
            doors[step * person] = doors[step * person] ? false : true;
        }
    }
}
