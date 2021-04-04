//  Created by naXa! on 18/02/2019.
//  Copyright © 2019 naXa!. All rights reserved.
//
/*
 This code is a practice Java interview question from testdome.com
 Problem statement:
    Modify the implementation of the Snapshot class so that an ArrayList stored in the snapshot
    is not affected by modifications to either the original or restored ArrayList.
 */
package dome;

import java.util.ArrayList;

public class Snapshot {
    private final ArrayList<Integer> data;

    public Snapshot(ArrayList<Integer> data) {
        this.data = new ArrayList<>(data);
    }

    public ArrayList<Integer> restore() {
        return new ArrayList<>(this.data);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Snapshot snap = new Snapshot(list);
        System.out.println(list); //It should log "[1,2]"
        list.set(0, 3);
        list = snap.restore();
        System.out.println(list); //It should log "[1,2]"
        list.add(4);
        list = snap.restore();
        System.out.println(list); //It should log "[1,2]"
    }
}
