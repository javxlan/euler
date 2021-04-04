package interview.sap;

import java.util.*;

public class ProblemB {
    private static final int MAX_N = 200;
    public static Claimant[] p;
    public static int tot = 1;
    private static int inq[];

    public static void main(String[] args) {
        inq = new int[MAX_N];

        Scanner scan = new Scanner(System.in);
        //System.out.println("input n m");
        String[] inputs = scan.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        p = new Claimant[MAX_N];
        for (int i = 1; i < p.length; i++) {
            p[i] = new Claimant();
        }
        //System.out.println("enter king name");
        p[1].name = scan.nextLine();
        p[1].parents[0] = 536870912 / 2;

        for (int i = 1; i <= n; ++i) {
            //System.out.println("enter " + i + " -th relation:");
            inputs = scan.nextLine().split(" ");
            int id1 = isExist(inputs[0]), id2 = isExist(inputs[1]), id3 = isExist(inputs[2]);
            p[id1].father = id2;
            p[id1].mother = id3;
            p[id2].son.add(id1);
            p[id3].son.add(id1);
        }
        breadthFirstSearch();

        double mostClose = 0;
        int id = -1;
        for (int j = 1; j <= m; ++j) {
            //System.out.println("enter candidate " + j + " :");
            String candidate = scan.nextLine().toString();
            for (int i = 2; i <= tot; ++i)
                if (matched(candidate, p[i].name)) {
                    if (p[i].parents[0] + p[i].parents[1] > mostClose) {
                        mostClose = p[i].parents[0] + p[i].parents[1];
                        id = i;
                    }
                    break;
                }
        }
        System.out.println(p[id].name);
    }


    public static boolean matched(String s1, String s2) {
        return s1.equals(s2);
    }

    public static int isExist(String s) {
        for (int i = 1; i <= tot; ++i)
            if (matched(s, p[i].name))
                return i;
        ++tot;
        p[tot].name = s;
        return tot;
    }

    public static void breadthFirstSearch() {
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(1);

        while (!Q.isEmpty()) {
            int x = Q.peek();
            Q.remove();
            inq[x] = 0;
            double now = (p[x].parents[0] + p[x].parents[1]) / 2;
            for (int i = 0; i < p[x].son.size(); ++i) {
                int y = p[x].son.get(i);
                int rel = x == p[y].father ? 0 : 1;
                double past = p[y].parents[rel];
                p[y].parents[rel] = now;
                if (past != p[y].parents[rel] && inq[y] != 1) {
                    inq[y] = 1;
                    Q.add(y);
                }
            }
        }
    }

    public static class Claimant {
        String name;
        List<Integer> son;
        double[] parents;
        int father, mother;

        public Claimant() {
            parents = new double[2];
            son = new ArrayList<>();
            parents[0] = parents[1] = 0;
            father = mother = 0;
        }
    }
}
