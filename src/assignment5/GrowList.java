package assignment5;

import java.util.*;

//GrowList is a mutable list that only gets longer.
public class GrowList<E> implements Iterable<E> {

	private Map<Integer,E> values;
	private long modCount = 0;

	public GrowList() { 
		values = new HashMap<Integer,E>();	
	}

	// add to the end of the list
	public void add(E o) {
		incrementMod();
		values.put(size(), o);	
	}

	// number of values in list
	public int size() { 
		return values.size(); 
	}

	// get ith value in list
	public E get(int i) { 
		if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
		return values.get(i);
	}

	// update ith value in list;  return previous value or null if none
	public E set(int i, E o) {
		if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
		incrementMod();
		return values.put(i, o);
	}

	// private helper method
	private boolean inRange(int i) { 
		return (i >= 0) && (i < size()); 
	}

	public String toString() {
		if (size() == 0) return "[]";
		String result = "[";
		for (int i = 0; i < size()-1; i++) {
			result += values.get(i) + ",";
		}
		return result + values.get(size() - 1) + "]";
	}
	
	public boolean repOk() {
		return (values != null && values.size() >= 0);
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
	
	private void incrementMod() {
		modCount = (modCount+1) % Long.MAX_VALUE;
	}

	@Override
	public Iterator<E> iterator() {
		return new GrowListIterator();
	}
	
	private class GrowListIterator implements Iterator<E> {
		
		private long modCount = GrowList.this.modCount;
		private Deque<E> values = new ArrayDeque<>(GrowList.this.values.values());
		
		public GrowListIterator() {}

		@Override
		public boolean hasNext() {
			if(modCount != GrowList.this.modCount)
				throw new ConcurrentModificationException();
			return !values.isEmpty();
		}

		@Override
		public E next() {
			if(modCount != GrowList.this.modCount)
				throw new ConcurrentModificationException();
			if(values.isEmpty())
				throw new NoSuchElementException();
			return values.removeFirst();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
}














// my code below

/*
 
 
//GrowList is a mutable list that only gets longer.
//public class GrowList<E> {
public class GrowList <E> {
	
	//private Map<Integer,E> values;
	private Map<Integer,E> values;
	
	public GrowList() { values = new HashMap<Integer,E>();}
	 
	// add to the end of the list
	public void add(E o) {
		values.put(size(), o);
	}

	// number of values in list
	public int size() { return values.size(); }
			
	//@SuppressWarnings("rawtypes")
	public Iterator GrowListIterator( ) {
		//E: Returns a generator that will produce
		//   the list that only gets longer
		//R: this must not be modified while the generator is in use.
		return new GrowListGen(this); 
	}
	
	// inner class
	//@SuppressWarnings("rawtypes")
	private class GrowListGen implements Iterator{
		//private GrowList<E> gl;
		private GrowList<E> gl;
		private int pointer; //nth item
		
		GrowListGen (GrowList<E> it){
			//Requires: it != null
			gl = it;
			//if (gl.values == 0)
			pointer= 0;
		}
			
		// add to the end of the list			
		
		public String toString() {
			if (size() == 0) return "[]";
			String result = "[";
			for (int i = 0; i < size()-1; i++) {
				result += gl.values.get(i) + ",";
			}
			return result + gl.values.get(size() - 1) + "]";
		}
				
		
		public boolean hasNext() {
			
			//if (n < size()) {			
			//	return true;
			//}
			//return false;
			
			return (pointer < size());
		}
		
		
		// Question on next() method 
		// Now next() for GrowList will not remove item from the list due to the contract 'list only gets longer'
				
		public Object next() throws NoSuchElementException {
			if (pointer == size()) {
				return new NoSuchElementException("GrowListGen.next()");
			}
			//get nth E
			E element = gl.values.get(pointer);
			
			//reduce the size
			//gl.values.remove(0);			
			//move pointer
			pointer++;
			return element;
		}
		
		public void remove() {
			new UnsupportedOperationException("GrowList.remove");
		}
		
	}
	
}
*/

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
