package assignment3;

import java.util.*;

//GrowList is a mutable list that only gets longer.
public class GrowListOrg<E> {

	private Map<Integer, E> values;

	public GrowListOrg() {
		values = new HashMap<Integer, E>();
	}

	// add to the end of the list
	public void add(E o) {
		values.put(size(), o);
	}

	// number of values in list
	public int size() {
		return values.size();
	}

	// get ith value in list
	public E get(int i) {
		if (!inRange(i))
			throw new IndexOutOfBoundsException("GrowList.get");
		return values.get(i);
	}

	// update ith value in list; return previous value or null if none
	public E set(int i, E o) {
		if (!inRange(i))
			throw new IndexOutOfBoundsException("GrowList.set");
		return values.put(i, o);
	}

	// private helper method
	private boolean inRange(int i) {
		return (i >= 0) && (i < size());
	}

	public String toString() {
		if (size() == 0)
			return "[]";
		String result = "[";
		for (int i = 0; i < size() - 1; i++) {
			result += values.get(i) + ",";
		}
		return result + values.get(size() - 1) + "]";
	}

	public static void main(String[] args) {
		GrowListOrg<String> list = new GrowListOrg<String>();
		System.out.println("list is:" + list);
				
		list.add("cat");
		System.out.println("list is:" + list);
		list.add("dog");
		System.out.println("list is:" + list);
		
		// add empty string test
		list.add("");
		System.out.println("after empty string - list is:" + list);
		
		// add null test				
		list.add(null);
		System.out.println("after null - list is:" + list);
				
		list.set(1, "bat");
		System.out.println("list.set(1, \"bat\") list is:" + list);
		
		// size
		System.out.println("size() of list is:" + list.size());
		
		// get -1 : Expect IOBE
		//System.out.println("list is:" + list.get(-1));
		
		// get 3
		System.out.println("after get(3) - list is:" + list.get(3));
		
		// set -1 bat : Expect IOBE
		//list.set(-1, "bat"); 
		//System.out.println("list.set(-1, \"bat\") list is:" + list);
		
		// set 2 wasEmpty
		list.set(2, "wasEmpty"); 
		System.out.println("list.set(2, \"wasEmpty\"); list is:" + list);
		
		

	}
}