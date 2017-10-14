package assignment6;

import java.util.*;

//See Liskov exercise 7.11
//This version is generified
public class Bag<E> {
	 // rep: map each object to the count of that object in this
	 // rep-inv:  range of map contains only positive integers
	 // Example:  A bag of 2 cats and a dog is map = { cat=2, dog=1 }
	 
	 private Map<E, Integer> map;

	 public Bag() {
	     map = new HashMap<E, Integer>();
	 }
	
	 // add 1 occurrence of e to this
	 public void insert(E e) {		 
		 if (isIn(e)) {			 		 
			 map.put(e, map.get(e)+1);
		 }
		 else {			 
			 map.put(e, 1);
		 }
	 }
	
	 // remove 1 occurrence of e from this
	 public void remove(E e) {
		 if (isIn(e)) {			 
			 if (map.get(e) == 1) {
				 map.remove(e);
			 }
			 else {
				 map.put(e, map.get(e)-1);
			 }				 
		 }		 
	 }
	
	 // return true iff e is in this
	 public boolean isIn(E e) {
		 return map.containsKey(e);
	 }
	 
	 // return cardinality of this
	 public int size() {	 
		 return map.size();
	 }
	
	 // if this is empty throw ISE
	 // else return arbitrary element of this
	 public E choose() {
		 if (size() == 0) {
			 throw new IllegalStateException();			 
		 }		 
		 return map.keySet().iterator().next();
	 }
	 
	 // conveniently, the <E,Integer> map is exactly the abstract state
	 public String toString() { return map.toString(); }
	 
	 public boolean repOK() {
		 //rep-inv:  range of map contains only positive integers
		 Iterator<Map.Entry<E, Integer>> itr = map.entrySet().iterator();		 		 
		 while (itr.hasNext()) {
			 Map.Entry<E, Integer> entry = (Map.Entry<E, Integer>)itr.next();
			 if (entry.getValue()<1) {
				 return false;
			 }
		 }		 
		 return true;
	 }
	 
	 public static void main(String[] args) {
		 Bag<String> bag = new Bag<String>();
					
	 	bag.insert("cat");
	 	bag.insert("cat");
	 	bag.insert("dog");
	
	 	System.out.println(bag);
	 	System.out.println(bag.isIn("dog"));
	 	System.out.println(bag.size());

	 	bag.insert("sheep");
	 	bag.insert("sheep");
	 	bag.insert("sheep");

	 	System.out.println(bag);
	 	System.out.println(bag.isIn("dog"));
	 	System.out.println(bag.size());

	 	bag.remove("dog");

	 	System.out.println(bag);
	 	System.out.println(bag.isIn("dog"));
	 	System.out.println(bag.size());

	 	bag.remove("dog");

	 	System.out.println(bag);
	 	System.out.println(bag.isIn("dog"));
	 	System.out.println(bag.size());			
	 }
	 
}

