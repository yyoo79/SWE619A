package assignment4;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrowListTest {

	@Test
	public void happyPath1() {
		GrowList<String> gl = new GrowList<>();
		try {
			assertTrue(gl.size()==0);
			gl.add("bat");
			assertTrue(gl.size()==1);
			assertEquals(gl.get(0), "bat");
			gl.add("cat");
			assertTrue(gl.size()==2);
			assertEquals(gl.get(1), "cat");
		} finally {
			assertTrue(gl.repOk());
		}
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void getNegativeIndex() {
		GrowList<String> gl = new GrowList<>();
		try {
			gl.add("bat");
			gl.add("cat");
			gl.get(-1);
		} finally {
			assertTrue(gl.repOk());
		}
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void setInvalidIndex() {
		GrowList<String> gl = new GrowList<>();
		try {
			gl.add("bat");
			gl.add("cat");
			gl.set(4, "dog");
		} finally {
			assertTrue(gl.repOk());
		}
	}
	
	// 1. An SDL mutant that causes the rep-invariant to fail. 
	// Demonstrate this with a call to repOk() from a (failing) JUnit test.
	// GTA: This is case when line #11 from GrowList.java is deleted by SDL
	@Test
	public void repInvFail() {
		GrowList<String> gl = new GrowList<>();
		assertTrue(gl.repOk());
	}
	
	// 2. An SDL mutant that causes a method contract to be violated. 
	//Demonstrate this with a call to the relevant method from a (failing) JUnit test.
	// GTA: This is the case when addSDLMutated resulted that line of code is deleted by SDL.
	@Test
	public void contractFail() {
		GrowList<String> gl = new GrowList<>();
		GrowList<String> gl2 = new GrowList<>(); // mutated
		gl.add("bat");
		gl2.addSDLMutated("bat");
		//System.out.println("list is:" + gl);
		//System.out.println("list is:" + gl2);
		assertEquals(gl, gl2);
	}

}
