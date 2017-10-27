package assignment7;

import java.util.*;

public class ListIndexer<T> implements Indexer<T>{
	
	private List<T> list;
	
	public ListIndexer(List<T> l) {
		list = l;
	}
	
	//Assignment description
	//Java List collections typically allow null entries. Make sure you handle null values (either in c or for x) correctly. 
	
	/**
	 * Finds the index of an element within an Indexer
	 * 
	 * @param c a list of elements
	 * @param x the element to find
	 * @throws NoSuchElementException if x is not found within c
	 * @throws NullPointerException if c is null or x is null
	 * @return The index where x can be found within c
	 */
	public static <E> int search (Indexer<E> c, E x) {
		/*
		if (c == null || x == null) {
			throw new NullPointerException();
		}
		*/		
		int maxIndex = c.size();
		for(int i = 0; i < maxIndex; i++) {
			E element = c.get(i);
			if((element == null && x == null) ||
					element.equals(x))	
				return i;
		}
		throw new NoSuchElementException();
	}
	
	@Override
	public T get(int i) {
		if(i >= size() || i < 0)
			throw new IndexOutOfBoundsException();
		Iterator<T> iter = list.iterator();
		int count = 0;
		while(count < i){ iter.next(); count++; }
		return iter.next();
	}
	
	@Override
	public int size() {
		return list.size();
	}	
	
}