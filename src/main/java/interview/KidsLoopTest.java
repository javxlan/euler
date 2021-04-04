package interview;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Javkhlan Gansukh
 */


class KidsLoopTest {

    @Test
    void solve() {
        KidsLoop test = new KidsLoop();
        test.threshold = 8;
        Assert.assertEquals(145, test.solve());
    }

    @Test
    void solveWhenNegativeThreshold() {
        KidsLoop test = new KidsLoop();
        test.threshold = -1;
        Assert.assertEquals(0, test.solve());
    }

    @Test
    void solveWhenDefaultThreshold() {
        KidsLoop test = new KidsLoop();
        Assert.assertEquals(592597, test.solve());
    }

    @Test
    void isVisited() {
        KidsLoop test = new KidsLoop();
        Point p = new Point(1, 2);
        test.visited.put(String.valueOf(p.x) + "," + String.valueOf(p.y), p);
        Assert.assertEquals(true, test.isVisited(p));
    }

    @Test
    void isNotVisited() {
        KidsLoop test = new KidsLoop();
        Point p = new Point(1, 2);
        Assert.assertEquals(false, test.isVisited(p));
    }

    @Test
    void isSafe() {
        KidsLoop test = new KidsLoop();
        test.threshold = 5;
        Point p = new Point(1, 2);
        Assert.assertEquals(true, test.isSafe(p));
    }

    @Test
    void isNotSafe() {
        KidsLoop test = new KidsLoop();
        test.threshold = 5;
        Point p = new Point(5, 4);
        Assert.assertEquals(false, test.isSafe(p));
    }

    @Test
    void digitSumNegativePoint() {
        KidsLoop test = new KidsLoop();
        Assert.assertEquals(9, test.digitSum(-153));
    }

    @Test
    void digitSum() {
        KidsLoop test = new KidsLoop();
        Assert.assertEquals(12, test.digitSum(75));
    }
}