package assignment8;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class BoundedQueueTest {

	@Test
	public void testMaxSize() {
        BoundedQueue<Integer> queue = new BoundedQueue<>(1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        queue.putAll(list);
        assertEquals(queue.maxSize,1);

	}
	
	@Test
	public void testCount() {
        BoundedQueue<Number> queue = new BoundedQueue<>(1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        queue.putAll(list);
        assertEquals(queue.rep.size(),1);

	}
	
	@Test
	public void testRepOK() {
        BoundedQueue<Integer> queue = new BoundedQueue<>(1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        queue.putAll(list);
        assertEquals(queue.repOK(),true);
	}
	
	//Yang - null allowed?
	@Test
	public void testStringAddNull() {
		BoundedQueue<String> queue = new BoundedQueue<>(3);
        queue.put("First");
        queue.put(null);
        assertEquals(queue.getCount(),1);
	}
	
	//Yang - null allowed?
	@Test
	public void testStringAddNullPutAll() {
		BoundedQueue<String> queue = new BoundedQueue<>(3);
        List<String> list = new ArrayList<>();
        list.add("First");
        list.add(null);
        list.add("Third");
        list.add("Fourth");
        queue.putAll(list);        
        assertEquals(queue.getCount(),3);
	}
	
	@Test
	public void testStringBQ2() {
		BoundedQueue<String> queue = new BoundedQueue<>(3);		
		queue.put("First");
		queue.put("Second");
		queue.put("Third");
		assertEquals(queue.getCount(),3);
	}
	
	@Test(expected=NullPointerException.class)
	public void zeroQueueSize() {
		BoundedQueue<Number> queue = new BoundedQueue<>(0);
		queue.put(6);
	}

	@Test
	public void putAllSmallerList() {
		BoundedQueue<String> queue = new BoundedQueue<>(13);
        List<String> list = new ArrayList<>();
        list.add("First");
        list.add("second");
        list.add("Third");
        list.add("Fourth");
        queue.putAll(list);        
        assertEquals(queue.getCount(),4);
	}

	@Test
	public void putAllLargerList() {
		BoundedQueue<String> queue = new BoundedQueue<>(3);
        List<String> list = new ArrayList<>();
        list.add("First");
        list.add("second");
        list.add("Third");
        list.add("Fourth");
        queue.putAll(list);        
        assertEquals(queue.getCount(),3);
	}
}
