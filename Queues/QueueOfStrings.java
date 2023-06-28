/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Queues;

public interface QueueOfStrings {
    public void enqueue(String item);

    public String dequeue();

    public boolean isEmpty();
}
