package interview.sap;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.LongStream;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.OptionalLong;
import java.util.stream.Stream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class ProblemC {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        StarsInACan solver = new StarsInACan();
        solver.solve(1, in, out);
        out.close();
    }

    static class StarsInACan {
        public boolean[][] vis;
        public Geometry3D.Point3D[] pts;
        public int n;
        public double ans;
        public int count;

        public double getVolume(int i, int j, int k) {
            Geometry3D.Point3D norm = Geometry3D.cross(pts[i], pts[j], pts[k]);
            double rad = CircleOperations.minEnclosingCircle(Geometry3D.project(pts, norm, pts[i])).r;
            double height = Arrays.asList(pts).stream().mapToLong(
                    p -> Math.abs(Geometry3D.dot(norm, Geometry3D.sub(p, pts[i])))
            ).max().getAsLong() / Geometry3D.norm(norm);
            return Math.PI * rad * rad * height;
        }

        public void dfs(int i, int j) {
            if (vis[i][j]) return;
            vis[i][j] = true;

            int k = 0;
            while (k == i || k == j) k++;
            for (int l = 0; l < n; l++) {
                if (l != i && l != j && Geometry3D.side(pts[i], pts[j], pts[k], pts[l]) > 0)
                    k = l;
            }
            ++count;
            ans = Math.min(ans, getVolume(i, j, k));
            dfs(k, j);
            dfs(i, k);
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            pts = new Geometry3D.Point3D[n];
            for (int i = 0; i < n; i++) {
                pts[i] = new Geometry3D.Point3D(
                        in.nextInt(),
                        in.nextInt(),
                        in.nextInt()
                );
            }
            vis = new boolean[n][n];
            int p = 0, q = 0;
            for (int k = 1; k < n; k++)
                if (pts[p].x > pts[k].x || (pts[p].x == pts[k].x && pts[p].y > pts[k].y))
                    p = k;
            while (q == p) q++;
            for (int k = 0; k < n; k++)
                if (k != p && Geometry3D.cross(pts[p], pts[q], pts[k]).z > 0)
                    q = k;

            ans = 1L << 60;
            dfs(p, q);
            out.printf("%.8f\n", ans);
        }

    }

    static class Geometry3D {
        public static Geometry3D.Point3D[] getPerp(Geometry3D.Point3D p) {
            Geometry3D.Point3D[] ret = new Geometry3D.Point3D[2];
            if (p.x == 0 && p.y == 0) {
                ret[0] = new Geometry3D.Point3D(1, 0, 0);
                ret[1] = new Geometry3D.Point3D(0, 1, 0);
                return ret;
            }
            ret[0] = new Geometry3D.Point3D(-p.y, p.x, 0);
            ret[1] = new Geometry3D.Point3D(-p.x * p.z, -p.y * p.z, p.x * p.x + p.y * p.y);
            return ret;
        }

        public static Objects.Point[] project(Geometry3D.Point3D[] pts, Geometry3D.Point3D normal, Geometry3D.Point3D origin) {
            Geometry3D.Point3D[] e = getPerp(normal);
            return Arrays.asList(pts).stream().map(
                    p -> new Objects.Point(
                            dot(e[0], sub(p, origin)) / norm(e[0]),
                            dot(e[1], sub(p, origin)) / norm(e[1])
                    )
            ).toArray(Objects.Point[]::new);
        }

        public static double norm(Geometry3D.Point3D p) {
            double m = Math.max(Math.max(Math.abs(p.x), Math.abs(p.y)), Math.abs(p.z));
            double x = p.x / m, y = p.y / m, z = p.z / m;
            return Math.sqrt(x * x + y * y + z * z) * m;
        }

        public static long dot(Geometry3D.Point3D a, Geometry3D.Point3D b) {
            return a.x * b.x + a.y * b.y + a.z * b.z;
        }

        public static Geometry3D.Point3D sub(Geometry3D.Point3D a, Geometry3D.Point3D b) {
            return new Geometry3D.Point3D(a.x - b.x, a.y - b.y, a.z - b.z);
        }

        public static Geometry3D.Point3D cross(Geometry3D.Point3D a, Geometry3D.Point3D b, Geometry3D.Point3D c) {
            Geometry3D.Point3D p = sub(b, a), q = sub(c, a);
            return new Geometry3D.Point3D(p.y * q.z - p.z * q.y, p.z * q.x - p.x * q.z, p.x * q.y - p.y * q.x);
        }

        public static double side(Geometry3D.Point3D a, Geometry3D.Point3D b, Geometry3D.Point3D c, Geometry3D.Point3D d) {
            return dot(cross(a, b, c), sub(d, a));
        }

        public static class Point3D {
            public long x;
            public long y;
            public long z;

            public Point3D(long x, long y, long z) {
                this.x = x;
                this.y = y;
                this.z = z;
            }

        }

    }

    static class Objects {
        public static class Point {
            public double x;
            public double y;

            public Point(double x, double y) {
                this.x = x;
                this.y = y;
            }

        }

        public static class Circle {
            public double x;
            public double y;
            public double r;

            public Circle(double x, double y, double r) {
                this.x = x;
                this.y = y;
                this.r = r;
            }

            public boolean containsStrictly(Objects.Point p) {
                return Utils.fastHypot(p.x - x, p.y - y) < r + Utils.EPS;
            }

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }

    }

    static class Utils {
        public static final double EPS = 1e-10;

        public static double fastHypot(double x, double y) {
            return Math.sqrt(x * x + y * y);
        }

    }

    static class CircleOperations {
        public static Objects.Circle minEnclosingCircle(Objects.Point[] points) {
            if (points.length == 0)
                return new Objects.Circle(0, 0, 0);
            if (points.length == 1)
                return new Objects.Circle(points[0].x, points[0].y, 0);
            Collections.shuffle(Arrays.asList(points));
            Objects.Circle circle = getCircumCircle(points[0], points[1]);
            for (int i = 2; i < points.length; i++) {
                if (!circle.containsStrictly(points[i])) {
                    circle = getCircumCircle(points[0], points[i]);
                    for (int j = 1; j < i; j++) {
                        if (!circle.containsStrictly(points[j])) {
                            circle = getCircumCircle(points[j], points[i]);
                            for (int k = 0; k < j; k++) {
                                if (!circle.containsStrictly(points[k])) {
                                    circle = getCircumCircle(points[i], points[j], points[k]);
                                }
                            }
                        }
                    }
                }
            }
            return circle;
        }

        public static Objects.Circle getCircumCircle(Objects.Point a, Objects.Point b) {
            double x = (a.x + b.x) / 2.;
            double y = (a.y + b.y) / 2.;
            double r = Utils.fastHypot(a.x - x, a.y - y);
            return new Objects.Circle(x, y, r);
        }

        public static Objects.Circle getCircumCircle(Objects.Point a, Objects.Point b, Objects.Point c) {
            double Bx = b.x - a.x;
            double By = b.y - a.y;
            double Cx = c.x - a.x;
            double Cy = c.y - a.y;
            double d = 2 * (Bx * Cy - By * Cx);
            if (Math.abs(d) < Utils.EPS)
                return getCircumCircle(new Objects.Point(Math.min(a.x, Math.min(b.x, c.x)), Math.min(a.y, Math.min(b.y, c.y))),
                        new Objects.Point(Math.max(a.x, Math.max(b.x, c.x)), Math.max(a.y, Math.max(b.y, c.y))));
            double z1 = Bx * Bx + By * By;
            double z2 = Cx * Cx + Cy * Cy;
            double cx = Cy * z1 - By * z2;
            double cy = Bx * z2 - Cx * z1;
            double x = cx / d;
            double y = cy / d;
            double r = Utils.fastHypot(x, y);
            return new Objects.Circle(x + a.x, y + a.y, r);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            } else {
                if (this.curChar >= this.numChars) {
                    this.curChar = 0;

                    try {
                        this.numChars = this.stream.read(this.buf);
                    } catch (IOException var2) {
                        throw new InputMismatchException();
                    }

                    if (this.numChars <= 0) {
                        return -1;
                    }
                }

                return this.buf[this.curChar++];
            }
        }

        public int nextInt() {
            int c;
            for (c = this.read(); isSpaceChar(c); c = this.read()) {
                ;
            }

            byte sgn = 1;
            if (c == 45) {
                sgn = -1;
                c = this.read();
            }

            int res = 0;

            while (c >= 48 && c <= 57) {
                res *= 10;
                res += c - 48;
                c = this.read();
                if (isSpaceChar(c)) {
                    return res * sgn;
                }
            }

            throw new InputMismatchException();
        }

        public static boolean isSpaceChar(int c) {
            return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
        }

    }
}
