package KtTest;/* *****************************************************************************
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

        for (int j = 0; j < countGenerations; j++) {
            HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();
            KtResults[] studentPoint = new KtResults[studentCount];
            int grantCounts = 0;
            for (int i = 0; i < studentCount; i++) {
                KtResults studentResult = new KtResults();
                studentResult.English = StdRandom.uniformInt(0, 51);
                studentResult.CritM = StdRandom.uniformInt(0, 16);
                studentResult.AnalM = StdRandom.uniformInt(0, 16);
                studentResult.Prof1 = StdRandom.uniformInt(0, 31);
                studentResult.Prof2 = StdRandom.uniformInt(0, 41);
                studentPoint[i] = studentResult;
            }

            for (int i = 0; i < studentCount; i++) {
                KtResults studentRes = studentPoint[i];
                int point = studentRes.English + studentRes.CritM + studentRes.AnalM
                        + studentRes.Prof1 + studentRes.Prof2;
                if (
                        studentRes.English >= 25
                                && (studentRes.CritM + studentRes.AnalM) >= 7
                                && studentRes.Prof1 >= 7 && studentRes.Prof2 >= 7
                                && point >= threshold
                ) {
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
