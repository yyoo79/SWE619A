package assignment11;

import java.util.HashSet;
import java.util.Set;


public class InstrumentedSet<E> extends ForwardingSet<E>{
	   private int addCount = 0;	

	   public InstrumentedSet(Set<E> s){ super(s); }
	   @Override public boolean add(E e){ addCount++; return super.add(e); }
	   public int getAddCount(){ return addCount; }
	   
		public static void main( String[] args ) {
	        System.out.println( "Hello World!" );
        	
	        Set<String> r = new HashSet<String>();
	        r.add("ant"); r.add("bee");

	        //Set<String> sh = new InstrumentedHashSet<String>();
	        //sh.addAll(r);

	        Set<String> s =  new InstrumentedSet<String>(r);
	        s.add("ant"); s.add("cat");

	        Set<String> t = new InstrumentedSet<String>(s);
	        t.add("dog");

	        r.remove("bee");
	        s.remove("ant");
	        
	        System.out.println("\nr now contains: " + r.toString());
	        System.out.println("\ns now contains: " + s.toString());
	        System.out.println("\nt now contains: " + t.toString());
	        
	        boolean s_equals_r = s.equals(r);
	        boolean r_equals_s = r.equals(s);
	        System.out.println("\ns_equals_r result is : " + s_equals_r + "\nr_equals_s is: " + r_equals_s );
	        
	        
		}
}