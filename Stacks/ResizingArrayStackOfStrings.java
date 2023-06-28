package Stacks;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayStackOfStrings {
    private String[] S;
    private int N = 0;

    public ResizingArrayStackOfStrings() {
        S = new String[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        if (N == S.length) {
            resize(2 * S.length);
        }
        S[N++] = item;
    }

    public String pop() {
        String item = S[--N];
        S[N] = null;

        if (N > 0 && N == S.length / 4) {
            resize(S.length / 2);
        }

        return item;
    }

    public void print() {
        for (int i = 0; i < S.length; i++) {
            String item = S[i];
            if (isLast(i)) {
                StdOut.print(item);
            }
            else {
                StdOut.print(item + ", ");
            }

        }
        StdOut.println();
    }

    public boolean isLast(int curIndex) {
        return curIndex == S.length - 1;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = S[i];
        }

        S = copy;
    }

    public static void main(String[] args) {
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();

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
