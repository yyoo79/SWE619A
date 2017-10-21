package assignment6;

import static org.junit.Assert.*;

import org.junit.Test;

public class BagTest {

	@Test
	/* 
	 * behavior of size() does not preserve the supertype's invariant after remove.
	 * supertype's size reduced remove() is called, but subtype changes that behavior that size doesn't change.   
	 */
	public void propertiesRuleViolates() {
		Bag<String> Bg = new Bag<String>();
		LiskovGenericSet<String> Ls = new LiskovGenericSet<String>();
		
		Bg.insert("cat");
		Bg.insert("cat");
		Bg.insert("dog");
		Bg.remove("cat");
		Bg.remove("dog");
		
		Ls.insert("cat");
		Ls.insert("cat");
		Ls.insert("dog");
		Ls.remove("cat");
		Ls.remove("dog");
				
		assertFalse(Bg.size() == Ls.size());
		
	}
	
	@Test
	/*
	 * The mutator method insert satisfies the supertype because it does not add
	 * duplicate elements which satisfies the rep-inv. It preserves cardinality
	 * because the only change it makes is to the Integer value of map, which is
	 * irrelevant to the superclass.
	 */
	public void insertSuccess() {
		Bag<String> Bg = new Bag<String>();
		LiskovGenericSet<String> Ls = new LiskovGenericSet<String>();

		Bg.insert("cat");
		Bg.insert("cat");
		Bg.insert("dog");

		Ls.insert("cat");
		Ls.insert("cat");
		Ls.insert("dog");

		assertEquals(Bg.isIn("cat"), Ls.isIn("cat"));
		
	}

	@Test
	/*
	 * The mutator method violates the Methods Rule of the Substitution principle
	 * because the subtype doesn't hold true for the post-condition. This evident in
	 * the case where the element count is > 1 we have changed the post-condition
	 * (reducing the element count as opposed to removing the element).
	 */
	public void removeFail() {
		Bag<String> Bg = new Bag<String>();
		LiskovGenericSet<String> Ls = new LiskovGenericSet<String>();

		Bg.insert("cat");
		Bg.insert("cat");
		Bg.insert("dog");
		Bg.remove("cat");

		Ls.insert("cat");
		Ls.insert("cat");
		Ls.insert("dog");
		Ls.remove("cat");
		
		//assertEquals(Bg.isIn("cat"), Ls.isIn("cat"));
		assertTrue(Bg.isIn("cat"));
		assertFalse(Ls.isIn("cat"));
	}

}
