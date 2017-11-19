package assignment11;

import java.util.Collection;
import java.util.Iterator;

public class ForwardingCollection<E> implements Collection<E> {
	private final Collection<E> s;

	public ForwardingCollection(Collection<E> s) { 
		this.s = s; 
	}
	
	@Override
	public boolean add(E e) { 
		return s.add(e);     
	}
	
	@Override
	public boolean remove(Object o) { 
		return s.remove(o);  
	}
	
	@Override 
	public boolean equals(Object o) { 
		return s.equals(o);  
	
	}
	
	@Override 
	public int hashCode() { 
		return s.hashCode();
	}
	
	@Override 
	public String toString() { 
		return s.toString();
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		return s.addAll(c);
	}
	
	@Override
	public void clear() {
		s.clear();
	}
	
	@Override
	public boolean contains(Object o) {
		return s.contains(o);
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		return s.containsAll(c);
	}
	
	@Override
	public boolean isEmpty() {
		return s.isEmpty();
	}
	
	@Override
	public Iterator<E> iterator() {
		return s.iterator();
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		return s.removeAll(c);
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		return s.retainAll(c);
	}
	
	@Override
	public int size() {
		return s.size();
	}
	
	@Override
	public Object[] toArray() {
		return s.toArray();
	}
	
	@Override
	public <T> T[] toArray(T[] a) {
		return s.toArray(a);
	}
}
