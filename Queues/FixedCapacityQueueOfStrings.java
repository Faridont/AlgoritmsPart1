/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityQueueOfStrings {
    private String[] S;
    private int head, tail;

    public FixedCapacityQueueOfStrings(int capacity) {
        S = new String[capacity];
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(String item) {
        S[tail] = item;
        tail++;
    }

    public void dequeue() {
        if (isEmpty()) {
            if (tail != 0) {
                tail = 0;
                head = 0;
            }
        }
        else {
            S[head] = null;
            head++;
        }
    }

    public boolean isLastForPrint(int curIndex) {
        return curIndex == S.length - 1;
    }

    public void print() {
        for (int i = 0; i < S.length; i++) {
            String item = S[i];
            if (isLastForPrint(i)) {
                StdOut.print(item);
            }
            else {
                StdOut.print(item + ", ");
            }

        }
        StdOut.println();
    }

    public static void main(String[] args) {
        StdOut.print("Input capacity: ");
        int capacity = StdIn.readInt();
        FixedCapacityQueueOfStrings fixedQueue = new FixedCapacityQueueOfStrings(capacity);

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                fixedQueue.dequeue();
            }
            else {
                fixedQueue.enqueue(s);
            }

            fixedQueue.print();
        }
    }
}
