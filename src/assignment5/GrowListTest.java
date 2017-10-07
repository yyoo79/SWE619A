package assignment5;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import java.util.Iterator;

public class GrowListTest {

	@Test(expected=UnsupportedOperationException.class)
	public void happyPath() {
		GrowList<String> gl = new GrowList<>();
		gl.add("bat");
		gl.add("cat");
		gl.add("dog");
		gl.add("elephant");
		Collection<String> seenValues = new Vector<>();
		seenValues.add("bat");
		seenValues.add("cat");
		seenValues.add("dog");
		seenValues.add("elephant");
		
		Iterator<String> iter = gl.iterator();
		assertTrue(iter.hasNext());
		System.out.println("iter.hasNext(): " + iter.hasNext());
		String value = iter.next();
		System.out.println("value: " + value);
		System.out.println("seenValues: " + seenValues);
		assertTrue(seenValues.contains(value));
		seenValues.remove(value);
		System.out.println("seenValues(after remove): " + seenValues);
		assertTrue(iter.hasNext());
		System.out.println("iter.hasNext(): " + iter.hasNext());
		value = iter.next();
		System.out.println("value: " + value);
		System.out.println("seenValues: " + seenValues);
		assertTrue(seenValues.contains(value));
		seenValues.remove(value);
		System.out.println("seenValues(after remove): " + seenValues);
		assertTrue(iter.hasNext());
		System.out.println("iter.hasNext(): " + iter.hasNext());
		value = iter.next();
		assertTrue(seenValues.contains(value));
		seenValues.remove(value);
		assertTrue(iter.hasNext());
		value = iter.next();
		assertTrue(seenValues.contains(value));
		seenValues.remove(value);
		assertFalse(iter.hasNext());
		iter.remove();
	}
	
	@Test (expected=NoSuchElementException.class)
	public void goPastEndOfList() {
		GrowList<String> gl = new GrowList<>();
		gl.add("bat");
		gl.add("cat");
		gl.add("dog");
		gl.add("elephant");
		Iterator<String> iter = gl.iterator();
		while(iter.hasNext()) {
			iter.next();
		}
		iter.next();
		
	}
	
	@Test (expected=ConcurrentModificationException.class)
	public void concurrentModificationViaAdd() {
		GrowList<String> gl = new GrowList<>();
		gl.add("bat");
		gl.add("cat");
		gl.add("dog");
		gl.add("elephant");
		Iterator<String> iter = gl.iterator();
		while(iter.hasNext()) {
			iter.next();
			gl.add("zebra");
		}
	}
	
	@Test (expected=ConcurrentModificationException.class)
	public void concurrentModificationViaSet() {
		GrowList<String> gl = new GrowList<>();
		gl.add("bat");
		gl.add("cat");
		gl.add("dog");
		gl.add("elephant");
		Iterator<String> iter = gl.iterator();
		while(iter.hasNext()) {
			iter.next();
			gl.set(3, "zebra");
		}
	}
	
	@Test (expected=ConcurrentModificationException.class)
	public void concurrentModificationViaSet2() {
		GrowList<String> gl = new GrowList<>();
		gl.add("bat");
		gl.add("cat");
		gl.add("dog");
		gl.add("elephant");
		Iterator<String> iter = gl.iterator();
		gl.set(3, "zebra");
		iter.next();
	}
	
	@Test
	public void setBeforeGetAfterIterator() {
		GrowList<String> gl = new GrowList<>();
		gl.add("bat");
		gl.add("cat");
		gl.add("dog");
		gl.set(1, "sheep");		
		Iterator<String> iter = gl.iterator();
		String temp ="";
		while(iter.hasNext()) {
			iter.next();			
			System.out.println("get(1): " + gl.get(1));
		}
	}
	
	/*
	@Test
	public void test() {
		GrowList<String> list = new GrowList<String>();
		
		
		//System.out.println("list is:" + list);
		list.add("cat");
		//System.out.println("list is:" + list);
		list.add("dog");
		//System.out.println("list is:" + list);
		list.add("bat");
		//System.out.println("list is:" + list);
		
//		list.set(1,"bat");
//		System.out.println("list is:" + list);		

		Iterator<?> itr = list.GrowListIterator();
					
	    System.out.println("list is: " + itr);
	    System.out.println("itr.hasNext(): " + itr.hasNext());	    
	    System.out.println("list is: " + itr);
	    System.out.println("next() is : " + itr.next());
	    System.out.println("list is: " + itr);
	    System.out.println("next() is : " + itr.next());
	    System.out.println("list is: " + itr);
	    System.out.println("next() is : " + itr.next());
	    System.out.println("list is: " + itr);
	    System.out.println("itr.hasNext(): " + itr.hasNext());
	    System.out.println("next() is : " + itr.next());
	    	     
	}
	*/

}
