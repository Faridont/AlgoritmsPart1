/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.ArrayList;
import java.util.List;

public class BruteCollinearPoints {
    private final Point[] points;
    private final LineSegment[] lineSegments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        checkExceptions(points);
        this.points = points;
        this.lineSegments = getLineSegments(points);
    }

    private void checkExceptions(Point[] points) {
        if (points == null) throw new IllegalArgumentException("Points is null");

        for (int i = 0; i < points.length; i++) {
            Point first = points[i];
            if (first == null) throw new IllegalArgumentException("Have null point");

            for (int j = 0; j < points.length; j++) {
                if (j == i) continue;
                Point second = points[j];
                if (second == null) throw new IllegalArgumentException("Have null point");
                if (first.compareTo(second) == 0)
                    throw new IllegalArgumentException("Have compayers points");
            }
        }
    }

    private LineSegment[] getLineSegments(Point[] points) {
        int N = points.length;
        List<LineSegment> ls = new ArrayList<LineSegment>();
        for (int i = 0; i < N; i++) {
            Point first = points[i];
            for (int j = 0; j < N; j++) {
                if (j == i) continue;
                Point second = points[j];
                for (int k = 0; k < N; k++) {
                    if (k == j || k == i) continue;
                    Point third = points[k];
                    for (int l = 0; l < N; l++) {
                        if (l == k || l == j || l == i) continue;
                        Point fourth = points[l];
                        double firstSlope = first.slopeTo(second);
                        double secondSlope = second.slopeTo(third);
                        double thirdSlope = third.slopeTo(fourth);

                        boolean isSloped = firstSlope == secondSlope && secondSlope == thirdSlope;
                        if (isSloped) {
                            ls.add(new LineSegment(first, fourth));
                        }
                    }
                }
            }
        }

        return (LineSegment[]) ls.toArray();
    }

    // the number of line segments
    public int numberOfSegments() {
        return this.lineSegments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return this.lineSegments;
    }
}
