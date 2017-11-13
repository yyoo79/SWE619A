package assignment10;

import java.util.*;

public class IntSetCorrect implements Cloneable {
	private List<Integer> els;

	public IntSetCorrect() {
		els = new ArrayList<Integer>();
	}
	
	
	// Here we have correctly override equals() and hashCode()	
	@Override
	public boolean equals(Object obj) { // Standard recipe
		if (!(obj instanceof IntSetCorrect))
			return false;
		IntSetCorrect s = (IntSetCorrect) obj;
		for (Integer i :this.els) {
			if (!s.els.contains(i)) return false;
		}		
		for (Integer j :s.els) {
			if (!this.els.contains(j)) return false;
		}
		return s.hashCode() == this.hashCode();
	}

	@Override
	public int hashCode() {
		int sum = 0;
		for (Integer i : els)
			sum += i.hashCode();
		return sum;
	}

	// This is correct implementation of clone
	// JUnit test for this implementation is cloneTestCorrect()
	@Override
	public IntSetCorrect clone() throws CloneNotSupportedException {
		IntSetCorrect isc;
		isc = (IntSetCorrect) super.clone();
		isc.els = new ArrayList<>(this.els);
		return isc;
	}

	public void add(Integer o) {
		if (!els.contains(o)) // duplication not allowed
			els.add(o);
	}
}