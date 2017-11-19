package assignment11;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class InstrumentedCollectionTest {

	@Test
	// This is JUnit test for #1
	public void equalFailCollections() {
		
        Collection<String> r = new HashSet<String>();
        r.add("ant"); r.add("bee");
        
        InstrumentedCollection<String> s =  new InstrumentedCollection<String>(r);
        
        //System.out.println("r.size() - " + r.size());
        //System.out.println("s.getAddCount() - " + s.getAddCount());
        
        s.add("ant"); s.add("cat");
        
        //System.out.println("r.size() - " + r.size());
        //System.out.println("s.getAddCount() - " + s.getAddCount());

        InstrumentedCollection<String> t = new InstrumentedCollection<String>(s);        
        t.add("dog");
    	
        //System.out.println("r.size() - " + r.size());
        //System.out.println("s.getAddCount() - " + s.getAddCount());
        //System.out.println("t.getAddCount() - " + t.getAddCount());
        
        r.remove("bee");
        s.remove("ant");
        
        //System.out.println("r.size() - " + r.size());
        //System.out.println("s.getAddCount() - " + s.getAddCount());
        //System.out.println("t.getAddCount() - " + t.getAddCount());
                
        /*
        In case of Set, s.equals(r) and r.equals(s) are true.
        However, in case of Collection. r.equals(s) is not true because in equals method,
        Collection is not instance of Set. This will fail.
        */
        assertEquals(s.equals(r), !r.equals(s));
        
	}
	
}
