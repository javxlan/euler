//  Created by naXa! on 19/02/2019.
//  Copyright © 2019 naXa!. All rights reserved.
//
/*
 This code is a practice Java interview question from testdome.com
 https://www.testdome.com/testing/sample/8549
 Problem statement: Fix the bugs.

 +Passes 2/2 tests
 */
package dome;

public class MathUtils {
    public static double average(int a, int b) {
        return (a + b) / 2.0;
    }

    public static void main(String[] args) {
        System.out.println(average(2,1));
    }
}
