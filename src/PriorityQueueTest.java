import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PriorityQueueTest {
    @Test
    void basicAddPeekPollRemove() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(17);
        queue.add(10);
        queue.add(13);
        queue.add(20);
        assertEquals(10, queue.peek()); 
        assertEquals(10, queue.poll());
        assertEquals(13, queue.poll());
        assertEquals(true, queue.remove(20));
        assertEquals(false, queue.remove(18));
    }

    @Test
    void containsSizeToString() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(17);
        queue.add(10);
        queue.add(13);
        assertEquals(3, queue.size());
        assertEquals(false, queue.contains(20));
        queue.add(20);
        assertEquals(4, queue.size());
        assertEquals(true, queue.contains(20));
        assertEquals(false, queue.contains(72));
    }

    @Test
    void heapifyTest() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(17);
        queue.add(10);
        queue.add(13);
        queue.add(72);
        queue.add(20);
        assertEquals("10 17 13 72 20", queue.toString());
        queue.remove(17);
        assertEquals("10 20 13 72", queue.toString());
    }
}