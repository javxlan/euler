package dome;

public class QuadraticEquation {
    public static Roots findRoots(double a, double b, double c) {
        double result = b * b - 4.0 * a * c;


        double r1 = (-b + Math.pow(result, 0.5)) / (2.0 * a);
        double r2 = (-b - Math.pow(result, 0.5)) / (2.0 * a);

        return new Roots(r1,r2);
        // throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }
}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
