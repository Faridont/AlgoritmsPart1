/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Test {
    public static void main(String[] args) {
        int XYscale = 10000;
        int N = 5000;
        Point[] points = new Point[N];
        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, XYscale);
        StdDraw.setYscale(0, XYscale);
        StdDraw.setPenRadius(0.001);  // make the points a bit larger

        for (int i = 0; i < N; i++) {
            Point p = new Point(StdRandom.uniformInt(XYscale), StdRandom.uniformInt(XYscale));
            points[i] = p;
        }

        for (int i = 0; i < N; i++) {
            points[i].draw();
        }

        for (int i = 0; i < N; i++) {
            int next = i + 1;
            if (next != N) {
                LineSegment ls = new LineSegment(points[i], points[i + 1]);
                ls.draw();
            }
        }
    }
}
