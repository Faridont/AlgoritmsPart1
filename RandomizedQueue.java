/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] S;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        S = (Item[]) new Object[2];
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (size == S.length) {
            resize(S.length * 2);
        }

        S[size] = item;
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();

        int randomId = StdRandom.uniformInt(0, size - 1);
        StdOut.println("RandomId: " + randomId);
        Item item = S[randomId];
        for (int i = randomId; i < size; i++) {
            S[i] = S[i - 1];
        }

        size--;

        if (size > 0 && size == S.length / 4) {
            resize(S.length / 2);
        }

        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();

        int randomId = StdRandom.uniformInt(size);
        Item item = S[randomId];

        return item;
    }

    private void resize(int newSize) {
        Item[] copy = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            copy[i] = S[i];
        }

        S = copy;
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int current = 0;
        private int[] iterorder;

        public RandomizedQueueIterator() {
            if (size > 0) {
                iterorder = new int[size];
                for (int i = 0; i < size; i++)
                    iterorder[i] = i;
                StdRandom.shuffle(iterorder, 0, size - 1);
            }
        }

        public boolean hasNext() {
            return current < size;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (current >= size) throw new java.util.NoSuchElementException();

            Item item = S[iterorder[current]];
            current = current + 1;
            return item;
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        int elCount = 100;
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

        StdOut.println("Is empty: " + queue.isEmpty());
        StdOut.println("Enqueue...");
        for (int i = 0; i < elCount; i++) {
            queue.enqueue(i);
        }

        StdOut.println("Queue size: " + queue.size);

        for (int i = 0; i < 10; i++) {
            int randEl = queue.sample();
            StdOut.println("Random element: " + randEl);
        }

        StdOut.println("Dequeue...");
        for (int i = 0; i < elCount; i++) {
            queue.dequeue();
        }
        StdOut.println("Queue size: " + queue.size);
    }
}
