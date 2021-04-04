package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println(findMovies(new int[]{20, 70, 90, 30, 60, 110}, 110));
        System.out.println(findMovies(new int[]{100, 180, 40 ,120, 10}, 250));

        System.out.println(findMovies(new int[]{100, 180, 40 ,120, 10}, 500));

    }
    public static List<Integer> findMovies(int[] movieDuration, int flightDuration) {

        flightDuration =flightDuration - 30;
        List<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);


        int[][] movies = new int[movieDuration.length][2];
        for(int i = 0; i < movieDuration.length; i++) {
            movies[i][0] = movieDuration[i];
            movies[i][1] = i;
        }
        Arrays.sort(movies, (a, b) -> a[0] - b[0]);

        int l = 0, r = movieDuration.length -1;
        int max = 0;
        while(l < r) {

            if(movies[l][0] + movies[r][0] != flightDuration){
                // find next
                if(movies[l][0] + movies[r][0] > flightDuration) {
                    r--;
                } else {
                    if(movies[l][0] + movies[r][0] > max) {
                        max = movies[l][0] + movies[r][0];
                        //ans.set(0, movies[l][1]);
                        //ans.set(1, movies[r][1]);
                    }
                    l++;
                }
            }else {
                result.set(0, movies[l][1]);
                result.set(1, movies[r][1]);
                break;
            }
        }

        return result;
    }

}