package Stacks;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        if (N == s.length) {
            StdOut.print("Array is full! ");
            return;
        }

        s[N++] = item;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;
        return item;
    }

    public boolean isLast(int curIndex) {
        return curIndex == s.length - 1;
    }

    public void print() {
        for (int i = 0; i < s.length; i++) {
            String item = s[i];
            if (isLast(i)) {
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
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(capacity);

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(s);
            }

            stack.print();
        }
    }
}
