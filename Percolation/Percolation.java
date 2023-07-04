/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final int TOP = 0;
    private final boolean[][] opened;
    private final int size;
    private final int bottom;
    private int openSites;
    private final WeightedQuickUnionUF qf;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        size = n;
        bottom = size * size + 1;
        qf = new WeightedQuickUnionUF(size * size + 2);
        opened = new boolean[size][size];
        openSites = 0;
    }

    public void open(int row, int col) {
        checkException(row, col);
        opened[row - 1][col - 1] = true;
        ++openSites;

        if (row == 1) {
            qf.union(getSiteIndex(row, col), TOP);
        }

        if (row == size) {
            qf.union(getSiteIndex(row, col), bottom);
        }

        if (row > 1 && isOpen(row - 1, col)) {
            qf.union(getSiteIndex(row, col), getSiteIndex(row - 1, col));
        }

        if (row < size && isOpen(row + 1, col)) {
            qf.union(getSiteIndex(row, col), getSiteIndex(row + 1, col));
        }

        if (col > 1 && isOpen(row, col - 1)) {
            qf.union(getSiteIndex(row, col), getSiteIndex(row, col - 1));
        }

        if (col < size && isOpen(row, col + 1)) {
            qf.union(getSiteIndex(row, col), getSiteIndex(row, col + 1));
        }
    }

    private void checkException(int row, int col) {
        if (row <= 0 || row > size || col <= 0 || col > size) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isOpen(int row, int col) {
        checkException(row, col);
        return opened[row - 1][col - 1];
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean isFull(int row, int col) {
        if ((row > 0 && row <= size) && (col > 0 && col <= size)) {
            return qf.find(TOP) == qf.find(getSiteIndex(row, col));
        }
        else throw new IllegalArgumentException();
    }

    private int getSiteIndex(int row, int col) {
        return size * (row - 1) + col;
    }

    public boolean percolates() {
        return qf.find(TOP) == qf.find(bottom);
    }

    public static void main(String[] args) {

    }
}
