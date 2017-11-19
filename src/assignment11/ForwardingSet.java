package assignment11;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ForwardingSet<E> implements Set<E> {
	   private final Set<E> s;

	   public ForwardingSet(Set<E> s){ this.s = s; }
	   public           boolean add(E e)        { return s.add(e);     }
	   public           boolean remove(Object o){ return s.remove(o);  }
	   @Override public boolean equals(Object o){ return s.equals(o);  }
	   // original code from exercise 10A didn't compile. I commented it out and replaced it with next line
	   //	   @Override public boolean hashCode()      { return s.hashCode(); }
	   @Override public int hashCode()      { return s.hashCode(); }
	   @Override public String  toString()      { return s.toString(); }
	   // Other forwarded methods from Set interface omitted
	@Override
	public boolean addAll(Collection<? extends E> arg0) { return s.addAll(arg0); }
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		s.clear();
	}
	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		//return false;
		return s.contains(arg0);
	}
	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		//return false;
		return s.containsAll(arg0);
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//return false;
		return s.isEmpty();
	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		//return null;
		return s.iterator();
	}
	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		//return false;
		return s.removeAll(arg0);
	}
	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		//return false;
		return s.retainAll(arg0);
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		//return 0;
		return s.size();
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		//return null;
		return s.toArray();
	}
	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		//return null;
		return s.toArray(arg0);
	}
	}