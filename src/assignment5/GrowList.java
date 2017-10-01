package assignment5;

import java.util.*;

//GrowList is a mutable list that only gets longer.
//public class GrowList<E> {
public class GrowList<E> {
	
	//private Map<Integer,E> values;
	private Map<Integer,E> values;
			
	@SuppressWarnings("rawtypes")
	public Iterator list( ) {
		//E: Returns a generator that will produce
		//   the list that only gets longer
		//R: this must not be modified while the generator is in use.
		return new GrowListGen(this); 
	}
	
	// inner class
	@SuppressWarnings("rawtypes")
	private class GrowListGen implements Iterator{
		//private GrowList<E> gl;
		private GrowList<E> gl;
		private int n; //next nth item
		
		GrowListGen (GrowList<E> it){
			//Requires: it != null
			gl = it;
			//if (gl.values == 0)
			n= 0;
		}
			
		// add to the end of the list	
		public GrowList<E> add(E o){
			//Map<Integer,E> copy = new HashMap<>(values);			
			gl.values.put(size(), o);
			GrowList<E> glcopy = gl;
			return glcopy;			
		}
		
		// number of values in list
		public int size() { return gl.values.size(); }
		
		// get ith value in list
		public E get(int i) { 
			if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
			return gl.values.get(i);
		}
		
		// update ith value in list;
		public GrowList<E> set(int i, E o) {
			if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
			//Map<Integer,E> copy = new HashMap<>(values);			
			gl.values.put(i, o);
			GrowList<E> glcopy = gl;
			return glcopy;
		}
		
		// private helper method
		private boolean inRange(int i) { return (i >= 0) && (i < size()); }
		
		public String toString() {
			if (size() == 0) return "[]";
			String result = "[";
			for (int i = 0; i < size()-1; i++) {
				result += gl.values.get(i) + ",";
			}
			return result + gl.values.get(size() - 1) + "]";
		}
				
		
		public boolean hasNext() {			
			if (n < size()) {	
				return true;
			}
			return false;						
		}
		
		public Object next() throws NoSuchElementException {
			//get nth E
			E element = get(n);
			//todo: implement this
			Object result = null;
			return result;
		}
		
	}
	/*
	public GrowList() { values = new HashMap<Integer,E>();}
	 
	  // add to the end of the list
	  public void add(E o) {
	     values.put(size(), o);
	  }
	
	  // number of values in list
	  public int size() { return values.size(); }
	
	  // get ith value in list
	  public E get(int i) { 
	     if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
	     return values.get(i);
	  }
	
	  // update ith value in list;  return previous value or null if none
	  public E set(int i, E o) {
	     if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
	     return values.put(i, o);
	  }
	  
	  // private helper method
	  private boolean inRange(int i) { return (i >= 0) && (i < size()); }
	
	  public String toString() {
	      if (size() == 0) return "[]";
	  String result = "[";
	  for (int i = 0; i < size()-1; i++) {
	      result += values.get(i) + ",";
	  }
	  return result + values.get(size() - 1) + "]";
	  }
	
	  public static void main(String[] args) {
	     GrowList<String> list = new GrowList<String>();
	
	     System.out.println("list is:" + list);
	 list.add("cat");
	 System.out.println("list is:" + list);
	 list.add("dog");
	 System.out.println("list is:" + list);
	 list.set(1,"bat");
	 System.out.println("list is:" + list);
	
	  }
	  */
}

/*
Goal: Iteration Abstraction, and a bit of Type Abstraction.

The point of this exercise is to show some of the power of interfaces in Java. 
In particular, the Iterable interface allows for the writing of extremely safe and compact for loops. 

Build a new version of GrowList that implements the Java Iterable interface. 
Your iterator() method in GrowList should be consistent with how iterators on lists normally behave. 
(But see below for a specific detail that you need to consider.)
 
Provide a reasonable set of JUnit tests for your implementation.
 
Notes: Implement the iterator with a private inner class. 	See Liskov's IntSet and Poly examples. 
For this exercise, don't build on top of the iterators available through the Map interface, 
even though doing so is typically preferable. 

Make sure you deal with the remove() method appropriately. 
That is, analyze valid GrowList behavior, and then conclude how remove() must behave. 
I expect to see a robust discussion of this point on Piazza. 
I'm going to refrain from jumping in until we see if the class can work out 
the correct answer without my input.

If you get stuck on the generics, do the exercise with the generic parameter E bound to String. 
You won't get full credit, but you'll earn most of the credit, and 
you won't get hung up focused on something that's not the point of the exercise. 
*/
