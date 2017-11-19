package assignment11;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class InstrumentedMapTest {

	@Test
	public void testMap() {
        Map<String, Integer> r = new HashMap<String, Integer>();
        r.put("ant",5); r.put("bee",3);
        
        //System.out.println("r.size() - " + r.size());
        
        InstrumentedMap<String, Integer> s =  new InstrumentedMap<String, Integer>(r);
        s.put("ant",4); s.put("cat",8);
        
        //System.out.println("----------------------------------");
        //System.out.println("r.size() - " + r.size());
        //System.out.println("s.getAddCount() - " + s.getAddCount());

        InstrumentedMap<String, Integer> t = new InstrumentedMap<String, Integer>(s);
        t.put("dog",9);
        
        //System.out.println("----------------------------------");
        //System.out.println("r.size() - " + r.size());
        //System.out.println("s.getAddCount() - " + s.getAddCount());
        //System.out.println("t.getAddCount() - " + t.getAddCount());
        
        r.remove("bee");
        s.remove("ant");
        
        //System.out.println("----------------------------------");
        //System.out.println("r.size() - " + r.size());
        //System.out.println("s.getAddCount() - " + s.getAddCount());
        //System.out.println("t.getAddCount() - " + t.getAddCount());
        
        
        // With mpas, equals() method works fine.
        assertEquals(s.equals(r), r.equals(s));
	}

}
