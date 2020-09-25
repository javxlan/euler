package leetcode.august;

public class BuildStairCase {


    public static void main(String[] args) {
        System.out.println(new BuildStairCase().count(1,8)-1);
    }

    public int count(int height, int left){
        if (left==0) return 1;
        if (left<height) return 0;

        return count(height+1,left-height) + count(height+1,left);
    }
}
