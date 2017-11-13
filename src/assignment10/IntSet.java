package assignment10;

import java.util.*;

public class IntSet implements Cloneable {  
   private List<Integer> els;
// adding a private constructor
   public IntSet () { els = new ArrayList<Integer>(); }
   
   @Override 
   public boolean equals(Object obj) {  // Standard recipe
      if (!(obj instanceof IntSet)) return false;

      IntSet s = (IntSet) obj;
      return false;
   }

   @Override 
   public int hashCode() { 
	// see below 
	      return 42;
   }

   // adding a private constructor
   private IntSet (List<Integer> list) { els = list; }

   @Override 
   public IntSet clone() { 
      return new IntSet ( new ArrayList<Integer>(els));
   }
   
   public void add (Integer o) {
	   if(!els.contains(o))	//duplication not allowed
		   els.add(o);
	}
}
