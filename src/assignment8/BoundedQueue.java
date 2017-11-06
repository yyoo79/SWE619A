package assignment8;

import java.util.*;

public class BoundedQueue<T> {

	protected List<T> rep;    
	protected int maxSize = 0;

	public BoundedQueue(int maxSize) throws IllegalArgumentException {
		if (maxSize > 0) {
			this.maxSize = maxSize;
			rep = new ArrayList<>(maxSize);
		}
	}

	public boolean isEmpty() {
		return rep.isEmpty();
	}

	public boolean isFull() {    	
		return (rep.size() == this.maxSize);
	}

	public int getCount() {
		return rep.size();
	}

	public void put(T e) {
		if (e != null && !isFull()) {
			rep.add(e);
		}
	}

	public T get() {
		T result = null;
		if(!isEmpty()) {
			result = rep.remove(0);  //queue => FIFO
		}
		return result;
	}

	public void putAll(List<? extends T> list) {    	    		
		if (list != null) {
			Iterator<? extends T> iter = list.iterator();
			while(!isFull() && iter.hasNext()) {
				put(iter.next());
			}
		}    	
	}

	public List<T> getAll() {
		List<T> result = new ArrayList<T>(rep);
		return result;
	}

	public boolean repOK() {
		// RepInv list cannot be null
		// list size must be less or equal to maxSize
		// maxSize must be greater than 0
		if (rep != null && rep.size() <= maxSize && maxSize > 0) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		BoundedQueue<Integer> queue = new BoundedQueue<Integer>(10);
		for (int i = 0; !queue.isFull(); i++) {
			queue.put(new Integer(i));
			System.out.println("put: " + i);
		}
		while (!queue.isEmpty()) {
			System.out.println("get: " + queue.get());
		}
	}
}

