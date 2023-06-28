package Stacks;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedStackOfStrings {
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String newItem) {
        Node oldfirst = first;
        first = new Node();
        first.item = newItem;
        first.next = oldfirst;
    }

    public String pop() {
        if (first == null) {
            throw new IllegalArgumentException();
        }

        String item = first.item;
        first = first.next;

        return item;
    }

    public boolean isLast(Node item) {
        return item.next == null;
    }

    public void print() {
        if (!isEmpty()) {
            Node item = first;
            while (item != null) {
                if (isLast(item)) {
                    StdOut.print(item.item);
                }
                else {
                    StdOut.print(item.item + ", ");
                }

                item = item.next;
            }
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();

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
