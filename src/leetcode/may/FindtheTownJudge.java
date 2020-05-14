package leetcode.may;

public class FindtheTownJudge {

    /**
     * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
     */
    public static void main(String[] args) {
        int[][] trust = {};
        System.out.println(new FindtheTownJudge().findJudge(1, trust));
    }

    public int findJudge(int N, int[][] trust) {
        if (N == 1 || trust == null) return 1;
        if (trust.length == 0 || trust == null) return -1;
        int[] vote = new int[N + 1];
        int[] person = new int[N + 1];
        int judge = -1;
        for (int[] people : trust) {
            vote[people[1]] += 1;
            person[people[0]] = 1;
            if (vote[people[1]] == N - 1) {
                judge = people[1];
            }
        }

        if (judge != -1 && person[judge] == 1) {
            judge = -1;
        }

        return judge;
    }
}
