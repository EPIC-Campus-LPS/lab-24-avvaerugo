import java.util.ArrayList;

/**
 * This class represents a Priority Queue (heap) based on the ordering
 * defined by the compareTo method for the element. "Lower" value will
 * mean "higher" priority.
 *
 * @param <E> the type of elements in the queue
 * @author
 */
public class PriorityQueue<E extends Comparable<E>> {

    private ArrayList<E> myHeap; //array representation of the heap

    /**
     * Creates an empty Priority Queue
     */
    public PriorityQueue() {
        myHeap = new ArrayList<E>();
    }

    /**
     * Adds the element to the priority queue
     *
     * @param element the element to be added
     */
    public void add(E element) {
        myHeap.add(element);
        reverseHeapify(myHeap.size() - 1);
    }

    /**
     * Swaps two elements in the queue.
     * Pre-condition: 0 <= posOne, posTwo < size of queue
     *
     * @param posOne the first element's position in the queue
     * @param posTwo the second element's position in the queue
     */
    private void swap(int posOne, int posTwo) {
        E temp = myHeap.get(posOne);
        myHeap.set(posOne, myHeap.get(posTwo));
        myHeap.set(posTwo, temp);
    }

    /**
     * Returns whether or not the element is in the heap
     *
     * @param element the element to be searched for
     * @return true if the element is in the queue, false otherwise
     */
    public boolean contains(E element) {
        return myHeap.contains(element);
    }

    /**
     * Returns the element of highest priority, null if queue is empty.
     * Post-condition: the queue is not changed
     *
     * @return the element of highest priority queue
     */
    public E peek() {
        return myHeap.get(0);
    }

    /**
     * Removes and returns the element of highest priority,
     * returns null if queue is empty.
     *
     * @return the element of highest priority
     */
    public E poll() {
        E polledVal = myHeap.get(0);
        if (remove(myHeap.get(0))) {
            return polledVal;
        } else {
            return null;
        }
    }

    /**
     * Will "sift down" the element at the given position
     * down to restore the heap property
     *
     * @param pos the starting position for heapify
     */
    private void heapify(int pos) {
        // checks need to be added to keep it in the heap size :c
        if (myHeap.size() > (pos * 2) + 2) {
            int minChildPos;
            if (myHeap.get((pos * 2) + 1).compareTo(myHeap.get((pos * 2) + 2)) > 0) {
                minChildPos = (pos * 2) + 2;
            } else {
                minChildPos = (pos * 2) + 1;
            }
            if (myHeap.get(pos).compareTo(myHeap.get(minChildPos)) > 0) {
                swap(pos, minChildPos);
                heapify(minChildPos);
            }
        } else if (myHeap.size() > (pos * 2) + 1) {
            int minChildPos = (pos * 2) + 1;
            if (myHeap.get(pos).compareTo(myHeap.get(minChildPos)) > 0) {
                swap(pos, minChildPos);
                heapify(minChildPos);
            }
        }
    }

    /**
     * Will "sift up" the element at the given position
     * up to restore the heap property
     *
     * @param pos the starting position for reverseHeapify
     */
    private void reverseHeapify(int pos) {
        E val = myHeap.get(pos);
        E parentVal = myHeap.get((pos - 1) / 2);
        if (val.compareTo(parentVal) < 0) {
            swap(pos, (pos - 1) / 2);
            reverseHeapify((pos - 1) / 2);
        }
    }

    /**
     * Finds and removes the given element from the queue.
     * Returns true if an element was deleted from the queue,
     * false otherwise.
     *
     * @param element the element to be removed from the queue
     * @return true if an element was removed from the queue, false otherwise
     */
    public boolean remove(E element) {
        int index = myHeap.indexOf(element);
        if (index == -1) {
            return false;
        } else {
            swap(index, myHeap.size() - 1);
            myHeap.remove(myHeap.size() - 1);
            heapify(index);
            return true;
        }
    }

    /**
     * Returns the number of elements in the queue
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return myHeap.size();
    }

    /**
     * Returns the String representation of the heap
     * (by the order of list, each element separated
     * with a single space)
     *
     * @return the String representation of the heap
     */
    public String toString() {
        String out = "";
        for (E i : myHeap) {
            out += i.toString() + " ";
        }
        return out.substring(0,out.length() - 1);
    }


    /**
     * Main method - contains console program used
     * for testing of the PriorityQueue class.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("i'm doing all my testing through junit tests because writing an entire console program is very exhausting and was never explicitly stated to be a requirement");
    }

}