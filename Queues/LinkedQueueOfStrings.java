/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedQueueOfStrings {
    private Node first, last = null;

    public class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
        }
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
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
        LinkedQueueOfStrings queue = new LinkedQueueOfStrings();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                if (!queue.isEmpty()) {
                    queue.dequeue();
                }
            }
            else {
                queue.enqueue(s);
            }

            queue.print();
        }
    }
}
