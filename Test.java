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
        int XYscale = 100;
        int N = 60;
        Point[] points = new Point[N];
        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, XYscale);
        StdDraw.setYscale(0, XYscale);
        StdDraw.setPenRadius(0.005);  // make the points a bit larger
        for (int i = 0; i < N; i++) {
            Point p = new Point(StdRandom.uniformInt(XYscale), StdRandom.uniformInt(XYscale));
            points[i] = p;
        }

        for (int i = 0; i < N; i++) {
            points[i].draw();
        }

        // for (int i = 0; i < N; i++) {
        //    Point p = points[i];
        //    for (int j = 0; j < N; j++) {
        //        if (j == i) continue;
        //        Point p2 = points[j];
        //        StdOut.println(
        //                "A: " + p.toString() + " B: " + p2.toString() + " = " + p.slopeTo(p2));
        //    }
        //}

        for (int i = 0; i < N; i++) {
            Point first = points[i];
            for (int j = 0; j < N; j++) {
                if (j == i) {
                    continue;
                }
                Point second = points[j];
                for (int k = 0; k < N; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    Point third = points[k];
                    for (int l = 0; l < N; l++) {
                        if (l == k || l == j || l == i) {
                            continue;
                        }
                        Point fourth = points[l];
                        double firstSlope = first.slopeTo(second);
                        double secondSlope = second.slopeTo(third);
                        double thirdSlope = third.slopeTo(fourth);

                        boolean isSloped = firstSlope == secondSlope && secondSlope == thirdSlope;
                        if (isSloped) {
                            first.drawTo(second);
                            second.drawTo(third);
                            third.drawTo(fourth);
                        }
                    }
                }
            }
        }

        BruteCollinearPoints bcp = new BruteCollinearPoints(points);
        LineSegment[] ls = bcp.segments();
        int segmentLength = bcp.numberOfSegments();

        StdOut.println("Segment length: " + segmentLength);
        for (int i = 0; i < segmentLength; i++) {
            LineSegment ls1 = ls[i];
            StdOut.println(ls1.toString());
        }

        StdOut.print("I am finish!!!");

        StdOut.print("I am finish!!!");

        // for (int i = 0; i < N; i++) {
        //    int next = i + 1;
        //    if (next != N) {
        //        LineSegment ls = new LineSegment(points[i], points[i + 1]);
        //        ls.draw();
        //    }
        //}
    }
}
