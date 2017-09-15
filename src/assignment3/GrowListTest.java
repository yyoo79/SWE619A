package assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrowListTest {
	
	GrowList<String> list = new GrowList<String>();
	
	@Test
	public void testAdd() {		
		list = list.add("cat");
		assertEquals(list.toString(), "[cat]");
	}
	
	@Test
	public void testSet() {		
		list = list.add("cat");
		list = list.add("dog");
		list = list.set(1, "bat");
		//System.out.println("list.set(1, \"bat\") list is:" + list);
		assertEquals(list.toString(), "[cat,bat]");
	}
	
	@Test
	public void testSize() {		
		list = list.add("cat");
		list = list.add("dog");
		list = list.set(1, "bat");
		//System.out.println("list.set(1, \"bat\") list is:" + list);
		assertEquals(list.size(), 2);
	}
	
	@Test
	public void testGet() {		
		list = list.add("cat");
		list = list.add("dog");
		list = list.set(1, "bat");
		//System.out.println("list.get(0) list is:" + list.get(0));
		assertEquals(list.get(0), "cat");
	}

}
