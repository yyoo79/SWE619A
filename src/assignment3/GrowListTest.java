package assignment3;
// SWE619 Assignment3 by 
// 1. Michael Risher
// 2. Chadia Habib
// 3. Yang Kyu Yoo

import static org.junit.Assert.*;
import org.junit.*;

public class GrowListTest {

	
	@Test (expected=IndexOutOfBoundsException.class)
	public void happyCreate() {
		GrowList<String> g = new GrowList<>();
		assertNotNull(g);
		assertTrue(g.size()==0);
		assertEquals("[]", g.toString());
		g.get(1);
	}
	
	@Test
	public void addElement() {
		GrowList<String> g = new GrowList<>();
		GrowList<String> f = g.add("cat");
		GrowList<String> h = g.add("cat");
		assertFalse(g==f);
		assertFalse(f==h);
		assertTrue(g.size()==0);
		assertTrue(f.size()==1);
		assertEquals(f.get(0), "cat");
		assertEquals(f.toString(), "[cat]");
		f=f.add("bird");
		assertTrue(f.size()==2);
		assertEquals(f.toString(), "[cat,bird]");
	}

	@Test
	public void setElement() {
		GrowList<String> g = new GrowList<>();
		GrowList<String> f = g.add("cat");
		GrowList<String> h = f.set(0,"dog");
		assertFalse(g==f);
		assertFalse(f==h);
		assertTrue(h.size()==1);
		assertTrue(f.size()==1);
		assertEquals(f.get(0), "cat");
		assertEquals(h.get(0), "dog");
	}
}
