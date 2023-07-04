/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;
    private final int experinmetsCount;
    private final double[] fractions;

    public PercolationStats(int n, int t) {
        if (n <= 0 || t <= 0) {
            throw new IllegalArgumentException();
        }

        experinmetsCount = t;
        fractions = new double[experinmetsCount];

        for (int expNum = 0; expNum < experinmetsCount; expNum++) {
            Percolation pr = new Percolation(n);
            int openedSites = 0;
            while (!pr.percolates()) {
                int i = StdRandom.uniformInt(1, n + 1);
                int j = StdRandom.uniformInt(1, n + 1);
                if (!pr.isOpen(i, j)) {
                    pr.open(i, j);
                    openedSites++;
                }
            }

            double fraction = (double) openedSites / (n * n);
            fractions[expNum] = fraction;
        }
    }

    public double mean() {
        return StdStats.mean(fractions);
    }

    public double stddev() {
        return StdStats.stddev(fractions);
    }

    public double confidenceLo() {
        return mean() - ((CONFIDENCE_95 * stddev()) / Math.sqrt(experinmetsCount));
    }

    public double confidenceHi() {
        return mean() + ((CONFIDENCE_95 * stddev()) / Math.sqrt(experinmetsCount));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[0]);
        PercolationStats prs = new PercolationStats(n, t);

        String confidence = "[" + prs.confidenceLo() + ", " + prs.confidenceHi() + "]";
        StdOut.println("mean                    = " + prs.mean());
        StdOut.println("stddev                  = " + prs.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }
}
