/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 * Dependencies: StdDraw.java
 **************************************************************************** */

import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point that) {
        if (this.y < that.y) return -1;
        if (this.y > that.y) return +1;
        if (this.x < that.y) return -1;
        if (this.x > that.y) return +1;
        return 0;
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        int cmp = compareTo(that);

        if (cmp == 0) return Double.NEGATIVE_INFINITY;
        if (y == that.y) return 0;
        if (x == that.x) return Double.POSITIVE_INFINITY;

        double yDiff = that.y - y;
        double xDiff = that.x - x;

        return yDiff / xDiff;
    }

    // return string representation of this point
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Comparator<Point> slopeOrder() {
        return new BySlope();
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    private class BySlope implements Comparator<Point> {
        public int compare(Point p, Point q) {
            double slope1 = p.slopeTo(Point.this);
            double slope2 = q.slopeTo(Point.this);

            if (slope1 < slope2) return -1;
            if (slope1 > slope2) return +1;

            return 0;
        }
    }
}
