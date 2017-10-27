package assignment7;

import java.util.*;

public class CollectionIndexer<T> implements Indexer<T> {
	
	protected Collection<T> searchable;
	
	public CollectionIndexer(Collection<T> c) {
		if(c == null)
			throw new NullPointerException();
		searchable = c;
	}	
	
	/**
	 * Finds the index of an element within an Indexer
	 * 
	 * @param c a collection of elements
	 * @param x the element to find
	 * @throws NoSuchElementException if x is not found within c
	 * @throws NullPointerException if c is null
	 * @return The index where x can be found within c
	 */
	public static <E> int search (Indexer<E> c, E x) {
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
		Iterator<T> iter = searchable.iterator();
		int count = 0;
		while(count < i){ iter.next(); count++; }
		return iter.next();
	}

	@Override
	public int size() {
		return searchable.size();
	}
	
}