package test;

import java.util.ArrayList;
import java.util.List;

public class Houses {

    public static void main(String[] args) {
        int[] states = {1, 1, 1, 0, 1, 1, 1, 1};
        int days = 2;
        Houses main = new Houses();
        System.out.println(main.cellCompete(states, days));

    }

    public List<Integer> cellCompete(int[] states, int days) {

        int[][] log = new int[days + 1][8];

        for (int day = 0; day <= days; day++) {
            System.out.println(day);
            for (int i = 0; i < 8; i++) {
                if (day == 0) {
                    // initial data
                    log[day][i] = states[i];
                } else {
                    // edge of linee
                    if (i == 0 || i == 7) {
                        // first house of line
                        if (i == 0) {
                            // next house
                            if (log[day - 1][i + 1] == 0) {
                                log[day][i] = 0;
                            } else {
                                log[day][i] = 1;
                            }
                        } else {
                            // last house of line
                            if (log[day - 1][i - 1] == 0) {
                                log[day][i] = 0;
                            } else {
                                log[day][i] = 1;
                            }
                        }
                    } else {
                        // normal
                        if ((log[day - 1][i - 1] == 0 && log[day - 1][i + 1] == 0) || (log[day - 1][i - 1] == 1 && log[day - 1][i + 1] == 1)) {
                            log[day][i] = 0;
                        } else {
                            log[day][i] = 1;
                        }
                    }
                }
            }
        }

        List<Integer> houses = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            houses.add(i, log[days][i]);
        }

        return houses;
    }
}
