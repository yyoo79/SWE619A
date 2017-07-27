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
		
		List<Integer> tempList = new ArrayList<Integer>();
		tempList.add(50);
		tempList.add(20);
		tempList.add(60);
		
		//change here git testing
		//change here git testing #2 pull testing
		//change #3 testing from desktop
		
		SWE619A swe619a = new SWE619A();
		
		Integer result = swe619a.min(tempList);
		assertEquals(new Integer(10), result);
		
	}

}
