/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class LevenshteinDistance {
    public static double GetDistance(String one, String two) {
        int n = one.length() + 1;
        int m = two.length() + 1;
        int[][] matrix = new int[n][m];

        int deletionCost = 1;
        int insertionCost = 1;

        for (int i = 0; i < n; i++) {
            matrix[i][0] = i;
        }

        for (int j = 0; j < m; j++) {
            matrix[0][j] = j;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int subCost = one.charAt(i - 1) == two.charAt(j - 1) ? 0 : 1;
                matrix[i][j] = Integer.min(
                        Integer.min(
                                matrix[i - 1][j] + deletionCost,
                                matrix[i][j - 1] + insertionCost
                        ),
                        matrix[i - 1][j - 1] + subCost
                );
            }
        }

        // for (int i = 0; i < n; i++) {
        //    if (i == 0) {
        //        StdOut.print("0 | 0 | ");
        //        for (int k = 0; k < two.length(); k++) {
        //            StdOut.print(two.charAt(k) + " | ");
        //        }
        //        StdOut.println();
        //    }
        //    for (int j = 0; j < m; j++) {
        //        if (j == 0 && i == 0) {
        //            StdOut.print("0 | ");
        //        }
        //        else {
        //            if (j == 0) StdOut.print(one.charAt(i - 1) + " | ");
        //        }
        //
        //        StdOut.print(matrix[i][j] + " | ");
        //    }
        //    StdOut.println();
        //}

        int max = Integer.max(one.length(), two.length());
        return 100.0 - (100.0 * matrix[n - 1][m - 1]) / max;
    }

    public static void main(String[] args) {
        String one = "KIRILL";
        String two = "KIRIL";
        StdOut.println("Result (" + two + ", " + one + "): " + GetDistance(two, one) + "%");
    }
}
