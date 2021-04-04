package leetcode.july;

import java.util.*;

public class Marathon {

    public static void main(String[] args) {

        String[] part = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] comp = new String[]{"stanko", "ana", "mislav"};
        System.out.println(solution(part, comp));
    }


    public static String solution(String[] participant, String[] completion) {


        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);

        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;

        /*String result = "";

        Arrays.sort(participant);
        Arrays.sort(completion);
        int length = completion.length;
        for (int i = 0; i < length; i++) {
            //System.out.println(participant[i] + " " + completion[i]);
            if (!participant[i].equals(completion[i])) {
                result = participant[i];
                break;
            }

        }
        if (result.equals("")) result = participant[length];*/


        /*ArrayList<String> parts = new ArrayList<String>();

        for (String ath: participant){
            parts.add(ath);
        }


        for (String part : completion) {
            parts.remove(part);
        }

        result= parts.get(0);*/

        //return result;
    }
}
