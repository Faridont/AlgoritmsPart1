/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Test {
    public static void main(String[] args) {
        int XYscale = 5000;
        int N = 10000;
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

        // BruteCollinearPoints bcp = new BruteCollinearPoints(points);
        // LineSegment[] ls = bcp.segments();
        // int segmentLength = bcp.numberOfSegments();
        //
        // StdOut.println("Segment length: " + segmentLength);
        // for (int i = 0; i < segmentLength; i++) {
        //    LineSegment ls1 = ls[i];
        //    ls1.draw();
        //    StdOut.println(ls1.toString());
        //}

        StdOut.print("I am finish :)");
    }
}
