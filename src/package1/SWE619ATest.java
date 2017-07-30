package package1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//import SWE619A;

public class SWE619ATest {

	@Test
	public void testMin() {
		//fail("Not yet implemented");
		
		//happy path tests. 
		List<Integer> tempList = new ArrayList<Integer>();
		tempList.add(50);
		tempList.add(20);
		tempList.add(60);		
		Integer result = SWE619A.min(tempList);
		assertEquals(new Integer(20), result);
		
	}
	
	@Test
	public void testMinNPE() {
	
		// @throws NullPointerException if list is null or
	    //         if any list elements are null
		List<Integer> tempList =null;
		Integer result = SWE619A.min(tempList);
		assertEquals(new Integer(10), result);
		
	}

}
