package dome;

import java.sql.Timestamp;
import java.util.*;

public class Platformer {

    List<Integer> jumps;
    public int pos;

    Tiles current;

    public Platformer(int n, int position) {
//        this.pos = position;
//        jumps = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            jumps.add(i);
//        }


        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public void jumpLeft() {
        //if(pos>1){}
        jumps.remove(pos);
        this.pos = pos - 2;
    }

    public void jumpRight() {
        jumps.remove(pos);
        pos = pos + 1;
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public int position() {
        return jumps.get(pos);
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        Platformer platformer = new Platformer(10000000, 5000000);
        System.out.println(platformer.position()); // should print 3
        System.out.println(" " + new Timestamp(System.currentTimeMillis()));
        for (int i = 0; i < 1000; i++) {
            platformer.jumpLeft();
            //System.out.println(platformer.position()); // should print 1
            platformer.jumpRight();
            //System.out.println(platformer.position()); // should print 4
        }

        System.out.println(" " + new Timestamp(System.currentTimeMillis()));
    }

    class Tiles {
        Tiles left;
        Tiles right;
        int val;

        public Tiles(int val) {
            left = null;
            right = null;
            this.val = val;
        }

        public int jumpLeft() {
            if (this.left != null) {
                this.left = this.left.left;
                return this.val;
            }
            return 0;
        }

        public int jumpRight() {
            if (this.right != null) {
                this.right = this.right.right;
                return this.val;
            }
            return 0;
        }
    }
}