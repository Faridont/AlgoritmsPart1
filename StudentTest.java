/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;

public class StudentTest {
    public static void main(String[] args) {
        int countGenerations = 100000;
        int generationRes = 0;
        int studentCount = 4000;
        int threshold = 84;
        int minPoint = 20;
        int maxPoint = 151;

        for (int j = 0; j < countGenerations; j++) {
            HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();
            int[] studentPoint = new int[studentCount];
            int grantCounts = 0;
            for (int i = 0; i < studentCount; i++) {
                studentPoint[i] = StdRandom.uniformInt(minPoint, maxPoint);
            }

            for (int i = 0; i < studentCount; i++) {
                int point = studentPoint[i];
                if (point > threshold) {
                    grantCounts++;
                }
                if (results.containsKey(point)) {
                    int curPointRes = results.get(point);
                    results.put(point, curPointRes + 1);
                }
                else {
                    results.put(point, 1);
                }
            }

            // results.forEach((key, value) -> {
            //    StdOut.println(key + ": " + value);
            //});
            // StdOut.println("Grant counts: " + grantCounts);
            generationRes += grantCounts;
        }
        StdOut.println("Grant counts avg: " + generationRes / countGenerations);
    }
}
