package ocp8.ch3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;


/**
 * Created by roman.tsypuk on 6/20/16.
 */
public class QueueTest {
    Deque<Integer> queue;

    @Before
    public void init() {
        queue = new ArrayDeque<>();
    }

    @Test
    public void testQueuePoll() {
        assertNull(queue.poll());
    }

    @Test(expected = NoSuchElementException.class)
    public void testQueuePop() {
        queue.add(1);
        assertEquals(new Integer(1), queue.pop());
        queue.pop();
    }

    @Test
    public void testQueueElement() {
        queue.add(10);
        assertEquals(new Integer(10), queue.element());
        assertEquals(new Integer(10), queue.element());
    }

    @Test(expected = NoSuchElementException.class)
    public void testQueueRemove() {
        queue.add(10);
        assertEquals(new Integer(10), queue.remove());
        queue.element();
    }

    @Test
    public void testQueuePush() {
        queue.add(10);
        queue.push(20);
        assertEquals(new Integer(20), queue.remove());
        assertEquals(new Integer(10), queue.remove());
    }
    @Test
    public void testQueuePeek() {
        queue.add(10);
        queue.add(20);
        assertEquals(new Integer(10), queue.peek());
        assertEquals(new Integer(10), queue.peek());
    }

}