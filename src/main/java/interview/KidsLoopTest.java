package interview;
/**
 * @author Javkhlan Gansukh
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KidsLoopTest {

    @Test
    void solve() {
        KidsLoop test = new KidsLoop();
        test.threshold = 8;
        assertEquals(145, test.solve());
    }

    @Test
    void solveWhenNegativeThreshold() {
        KidsLoop test = new KidsLoop();
        test.threshold = -1;
        assertEquals(0, test.solve());
    }

    @Test
    void solveWhenDefaultThreshold() {
        KidsLoop test = new KidsLoop();
        assertEquals(592597, test.solve());
    }

    @Test
    void isVisited() {
        KidsLoop test = new KidsLoop();
        Point p = new Point(1, 2);
        test.visited.put(String.valueOf(p.x) + "," + String.valueOf(p.y), p);
        assertEquals(true, test.isVisited(p));
    }

    @Test
    void isNotVisited() {
        KidsLoop test = new KidsLoop();
        Point p = new Point(1, 2);
        assertEquals(false, test.isVisited(p));
    }

    @Test
    void isSafe() {
        KidsLoop test = new KidsLoop();
        test.threshold = 5;
        Point p = new Point(1, 2);
        assertEquals(true, test.isSafe(p));
    }

    @Test
    void isNotSafe() {
        KidsLoop test = new KidsLoop();
        test.threshold = 5;
        Point p = new Point(5, 4);
        assertEquals(false, test.isSafe(p));
    }

    @Test
    void digitSumNegativePoint() {
        KidsLoop test = new KidsLoop();
        assertEquals(9, test.digitSum(-153));
    }

    @Test
    void digitSum() {
        KidsLoop test = new KidsLoop();
        assertEquals(12, test.digitSum(75));
    }
}