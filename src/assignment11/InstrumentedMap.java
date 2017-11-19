package assignment11;

import java.util.Map;

public class InstrumentedMap<K,V> extends ForwardingMap<K,V>{
	   private int addCount = 0;	

	   public InstrumentedMap(Map<K,V> s){ super(s); }
	   @Override public V put(K key,V e){ addCount++; return super.put(key,e); }
	   public int getAddCount(){ return addCount; }
}
