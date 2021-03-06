package assignment4;

import java.util.*;

//GrowList is a mutable list that only gets longer.
public class GrowList<E> {

	private Map<Integer, E> values;

	public GrowList() { 
		values = new HashMap<Integer,E>();	//Mutation #1 - violates the rep-invariant
	}
	
	// add to the end of the list
	public void add(E o) {
		values.put(size(), o);	//Mutation #2 - violates contract without violating rep-invariant
	}
	
	// add to the end of the list
	public void addSDLMutated(E o) {
		//values.put(size(), o);	//Mutation #2 - violates contract without violating rep-invariant
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
	
	//repOK
	public boolean repOk() {
		return (values != null && values.size() >= 0);
	}
	
	//statement deletion mutation operator (SDL)
	public void remove(int i) {
		
	}

	public static void main(String[] args) {
		GrowList<String> list = new GrowList<String>();

		System.out.println("list is:" + list);
		list.add("cat");
		System.out.println("list is:" + list);
		list.add("cat");
		System.out.println("list is:" + list);
		list.set(1, "bat");
		System.out.println("list is:" + list);

	}
}

/*
	Consider the statement deletion mutation operator (SDL) , which deletes a statement from a program. 
	A mutant produced by this operator is detected 
	if there is a test that has different outputs on the original program and the mutated program. 
	Find two instances of this operator: 
	1. An SDL mutant that causes the rep-invariant to fail. 
	Demonstrate this with a call to repOk() from a (failing) JUnit test.
	2. An SDL mutant that causes a method contract to be violated. 
	Demonstrate this with a call to the relevant method from a (failing) JUnit test. 
	To help out the GTA, document your SDL faults with easily identifiable comments in your code. 
	Make the two faults/tests independent, which means that 
	you find a test that violate the rep-invariant without violating a contract and vice versa. 
	If that is not possible, explain why not. 
*/