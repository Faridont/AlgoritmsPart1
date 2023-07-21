/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        int k = Integer.valueOf(args[0]);

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-")) break;
            q.enqueue(item);
        }
        while (k > 0) {
            StdOut.println(q.dequeue());
            k--;
        }
    }
}
