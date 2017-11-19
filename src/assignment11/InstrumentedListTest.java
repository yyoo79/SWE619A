package assignment11;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class InstrumentedListTest {
	
	@Test
	// This is Junit test #2 with lists.
	public void testList() {
        List<String> r = new ArrayList<String>();
        r.add("ant"); r.add("bee");

        InstrumentedList<String> s =  new InstrumentedList<String>(r);
        
        //System.out.println("r.size() - " + r.size());
        //System.out.println("s.getAddCount() - " + s.getAddCount());
                
        s.add("ant"); s.add("cat");
        
        //System.out.println("r.size() - " + r.size());
        //System.out.println("s.getAddCount() - " + s.getAddCount());

        InstrumentedList<String> t = new InstrumentedList<String>(s);
        t.add("dog");
                
        //System.out.println("r.size() - " + r.size());
        //System.out.println("s.getAddCount() - " + s.getAddCount());
        //System.out.println("t.getAddCount() - " + t.getAddCount());
                
        r.remove("bee");
        s.remove("ant");
                
        //System.out.println("r.size() - " + r.size());
        //System.out.println("s.getAddCount() - " + s.getAddCount());
        //System.out.println("t.getAddCount() - " + t.getAddCount());
        
        //In case of List, equals() method works fine.
        assertEquals(s.equals(r), r.equals(s));
	}
	
}
