package assignment11;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ForwardingMap<K,V> implements Map<K,V> {
	private Map<K,V> s;
	
	public ForwardingMap(Map<K,V> m) {
		s = m;
	}
	
	@Override
	public boolean equals(Object o) {
		return s.equals(o);
	}

	@Override
	public String toString() {
		return s.toString();
	}
	
	@Override
	public int hashCode() {
		return s.hashCode();
	}
	
	@Override
	public int size() {
		return s.size();
	}

	@Override
	public boolean isEmpty() {
		return s.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return s.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return s.containsValue(value);
	}

	@Override
	public V get(Object key) {
		return s.get(key);
	}

	@Override
	public V put(K key, V value) {
		return s.put(key, value);
	}

	@Override
	public V remove(Object key) {
		return s.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		s.putAll(m);
	}

	@Override
	public void clear() {
		s.clear();
	}

	@Override
	public Set<K> keySet() {
		return s.keySet();
	}

	@Override
	public Collection<V> values() {
		return s.values();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return s.entrySet();
	}

}

