package assignment2;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

@RunWith(Parameterized.class)
public class FindPrimeFactorTest {

	 List<Integer> a;
	 List<Integer> b;

	 int index;

	 public FindPrimeFactorTest(List<Integer> a, List<Integer> b, int index) {
	     this.a = a;
	     this.b = b;
	     this.index = index;
	 }

	@Parameters public static Collection<Object[]> parameters() {

	    List<Object[]> list = new ArrayList<Object[]>();
	    list.add(new Object[] {new ArrayList<Integer>(Arrays.asList(4)),        new ArrayList<Integer>(Arrays.asList(2)),      0});
	    list.add(new Object[] {new ArrayList<Integer>(Arrays.asList(-4)),        new ArrayList<Integer>(Arrays.asList(2)),      0});
	    list.add(new Object[] {new ArrayList<Integer>(Arrays.asList(10,12)),     new ArrayList<Integer>(Arrays.asList(0,3)),    1});
	    list.add(new Object[] {new ArrayList<Integer>(Arrays.asList(10,12)),     new ArrayList<Integer>(Arrays.asList(6,3)),    1});
	    list.add(new Object[] {new ArrayList<Integer>(Arrays.asList(10,12,15)),  new ArrayList<Integer>(Arrays.asList(6,4,3)),  2});
	    list.add(new Object[] {new ArrayList<Integer>(Arrays.asList(10,12,-15)), new ArrayList<Integer>(Arrays.asList(6,4,3)),  2});
	    list.add(new Object[] {new ArrayList<Integer>(Arrays.asList(10,12,-15)), new ArrayList<Integer>(Arrays.asList(-3,4,3)), 2});

	    return list;
	}

	 @Test
	 public void testNormalCases() {
	     assertEquals(FindPrimeFactor.findPrimeFactor(a, b), index);
	 }

}
