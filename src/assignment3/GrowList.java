package assignment3;
// SWE619 Assignment3 by 
// 1. Michael Risher
// 2. Chadia Habib
// 3. Yang Kyu Yoo

import java.util.*;

public class GrowList  <E> {

	  private Map<Integer,E> values;

	  public GrowList() { values = new HashMap<Integer,E>();}
	  
	  //private constructor
	  private GrowList(Map<Integer, E> m) {
		  values = m;
	  }

	  // add to the end of the list	  
	  public GrowList<E> add(E o) {
	     Map<Integer,E> copy = new HashMap<>(values);
	     copy.put(size(), o);
	     return new GrowList<E>(copy);
	  }

	  // number of values in list
	  public int size() { return values.size(); }

	  // get ith value in list
	  public E get(int i) { 
	     if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
	     return values.get(i);
	  }

	  // update ith value in list;
	  public GrowList<E> set(int i, E o) {
	     if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
	     Map<Integer,E> copy = new HashMap<>(values);
	     copy.put(i, o);
	     return new GrowList<E>(copy);
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
	     list = list.add("cat");
	     System.out.println("list is:" + list);
	     list = list.add("dog");
	     System.out.println("list is:" + list);
	     list = list.set(1,"bat");
	     System.out.println("list is:" + list);

	  }
}
