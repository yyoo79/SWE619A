package assignment10;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SubIntSetCloneTest {

	// STORY #1
	// This demonstrates the why clone doesn't work on SubIntSet 
	// because IntSet has clone with covariant return type (returns IntSet).
	// When the test - cloneTestFail() tries to have the clone object by using clone method,
	// it doesn't return desirable clone object class.
	//
	// Subtype - SubIntSet's clone() method causes 'ClassCastExcpetion.
	// Detail error - "IntSet cannot be cast to SubIntSet"
	
	@Test (expected=ClassCastException.class)
	public void cloneTestFail() {
		SubIntSet sis = new SubIntSet();
		SubIntSet sis2 = sis.clone();
	}
	
	// STORY #2
	// ** Please note that we created a new class called IntSetCorrect **
	// ** Please also note that SubIntSetCorrect class needs to be created
	//    to accommodate the JUnit testing ** 
	// This demonstrates the correct implementation of clone() of InSetCorrect.
	// As we mentioned in STORY #1, clone must use super.clone() to connect
	// a hierarchy of subclass(es). Also it stores array list of elements value.
	// 	
	@Test
	public void cloneTestCorrect() {
		try {
		SubIntSetCorrect sis = new SubIntSetCorrect();
		SubIntSetCorrect sis2 = sis.clone();
		assertTrue(sis.equals(sis2));
		} catch(Exception e) {
			fail();
		}
	}
	
	// STORY #3
	// Correctly implemented methods of equals() and hashCode() from IntSetCorrect
	// mainly does 2 comparison:
	// 1. It checks if all elements are contains between 2 sets
	// 2. It checks the sums of each element' hashCode are equal.
 
	@Test
	public void correctEqualsHashCodeTest() {		
		IntSetCorrect isc = new IntSetCorrect();
		isc.add(1);		isc.add(2);		isc.add(3);
		IntSetCorrect isc2 = new IntSetCorrect();
		isc2.add(3);		isc2.add(1);		isc2.add(2);
		assertTrue(isc.equals(isc2));		
	}
	
	@Test
	public void correctEqualsHashCodeTest2() {
		IntSetCorrect isc = new IntSetCorrect();
		isc.add(10);		isc.add(4);		isc.add(3);		
		IntSetCorrect isc2 = new IntSetCorrect();
		isc2.add(2);		isc2.add(6);		isc2.add(9);
		assertTrue(!isc.equals(isc2));	
	}
	
	
	

}