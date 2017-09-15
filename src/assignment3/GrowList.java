package assignment3;

import java.util.*;

//GrowList is a mutable list that only gets longer.
public class GrowList<E> {

	private Map<Integer, E> values;

	public GrowList() { values = new HashMap<Integer, E>(); }
	
	//Chadia's comment: this a new private constructor
	/*
	private GrowList(Map<Integer, E> val) {
		values = new HashMap<Integer, E>();
		values.putAll(val);
	}
	*/	
	
	// Yang's private constructor	
	private GrowList(Map<Integer,E> val) {
		this.values = val;
	}
		
	//Chadia's comment: this is a mutator function need to change to make it mutable
	// add to the end of the list
	/*
	public GrowList<E> add(E o) {
		GrowList<E> GL = new GrowList<E>(values);
		GL.values.put(size(), o);
		return GL;
	}
	*/	
	
	// Yang's add function (producer)
	// add to the end of the list	
	public GrowList<E> add(E o) {
		Map<Integer, E> newMap = new HashMap<Integer,E>(values);
		newMap.put(size(), o);
		return new GrowList<E>(newMap);
	}

	// number of values in list
	// Chadia's comment: this an observer and no need to modify
	public int size() { return values.size(); }

	// get ith value in list
	// Chadia's comment: this an observer and no need to modify
	public E get(int i) {
		if (!inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
		return values.get(i);
	}

	// update ith value in list;  return previous value or null if none
	// Chadia's comment: this a mutator and observer, so we need to replace with 2
	// different functions
	// update ith value in list; return previous value or null if none
	/*
	public GrowList<E> set(int i, E o) {
		if (!inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
		GrowList<E> GL = new GrowList<E>(values);
		GL.values.put(i, o);
		return GL;
	}
	*/
	
	// Yang's set fuction (producer)
	// update ith value in list; return previous value or null if none	
	public GrowList<E> set(int i, E o) {
		if (!inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
		Map<Integer, E> newMap = new HashMap<Integer,E>(values);
		if (newMap.containsKey(i)) {
			newMap.put(i, o);
			return new GrowList<E>(newMap);
		}
		return null;
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
			
		GrowList<String> list = new GrowList<String>();
		System.out.println("list is:" + list);
				
		list = list.add("cat");
		System.out.println("list is:" + list);
		list = list.add("dog");
		System.out.println("list is:" + list);
		
		// add empty string test
		list = list.add("");
		System.out.println("after empty string - list is:" + list);
		
		// add null test				
		list = list.add(null);
		System.out.println("after null - list is:" + list);
				
		list = list.set(1, "bat");
		System.out.println("list.set(1, \"bat\") list is:" + list);
		
		// size		 
		System.out.println("size() of list is:" + list.size());
		
		// get -1 : Expect IOBE
		//System.out.println("list is:" + list.get(-1));
		
		// get 3
		System.out.println("after get(3) - list is:" + list.get(3));
		
		// set -1 bat : Expect IOBE
		//list = list.set(-1, "bat"); 
		//System.out.println("list.set(-1, \"bat\") list is:" + list);
		
		// set 2 wasEmpty
		list = list.set(2, "wasEmpty"); 
		System.out.println("list.set(2, \"wasEmpty\"); list is:" + list);
		

	}
}
