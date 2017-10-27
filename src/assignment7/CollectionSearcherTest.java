package assignment7;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CollectionSearcherTest {

	@Test
	public void happyPathSequential() {
		List<String> sorted = new Vector<>();
		sorted.add("Hippo");
		sorted.add("Rhino");
		sorted.add("Fox");
		sorted.add("Cat");
		Indexer<String> indexer = new CollectionIndexer<>(sorted);
		assertEquals(CollectionIndexer.search(indexer, "Rhino"), 1);
		assertEquals(CollectionIndexer.search(indexer, "Hippo"), 0);
		assertEquals(CollectionIndexer.search(indexer, "Fox"), 2);
		assertEquals(CollectionIndexer.search(indexer, "Cat"), 3);
	}
	
	@Test
	public void happyPathHash() {
		Set<Double> sorted = new HashSet<>();
		sorted.add(1.14);
		sorted.add(0.736);
		sorted.add(6974.194);
		sorted.add(-571038429.1);
		Indexer<Double> indexer = new CollectionIndexer<>(sorted);
		int index = CollectionIndexer.search(indexer, 1.14);
		assertTrue(index >= 0 && index < indexer.size());
		index = CollectionIndexer.search(indexer, 0.736);
		assertTrue(index >= 0 && index < indexer.size());
		index = CollectionIndexer.search(indexer, 6974.194);
		assertTrue(index >= 0 && index < indexer.size());
		index = CollectionIndexer.search(indexer, -571038429.1);
		assertTrue(index >= 0 && index < indexer.size());
	}
	
	@Test
	public void happyPathSorted() {
		SortedSet<Integer> sorted = new TreeSet<>();
		sorted.add(1);
		sorted.add(7);
		sorted.add(49);
		sorted.add(-13);
		Indexer<Integer> indexer = new CollectionIndexer<>(sorted);
		assertEquals(CollectionIndexer.search(indexer, 1), 1);
		assertEquals(CollectionIndexer.search(indexer, -13), 0);
		assertEquals(CollectionIndexer.search(indexer, 7), 2);
		assertEquals(CollectionIndexer.search(indexer, 49), 3);
	}
	
	@Test(expected=NullPointerException.class)
	public void nullConstructor() {
		new CollectionIndexer<Object>(null);
	}
	
	@Test
	public void nullElements() {
		List<Integer> sorted = new ArrayList<>();
		sorted.add(1);
		sorted.add(null);
		sorted.add(49);
		sorted.add(-13);
		Indexer<Integer> indexer = new CollectionIndexer<>(sorted);
		assertEquals(CollectionIndexer.search(indexer, null), 1);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void notFound() {
		SortedSet<Integer> sorted = new TreeSet<>();
		sorted.add(1);
		sorted.add(7);
		sorted.add(49);
		sorted.add(-13);
		Indexer<Integer> indexer = new CollectionIndexer<>(sorted);
		CollectionIndexer.search(indexer, 3);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(expected=NoSuchElementException.class)
	public void rawTypes() {
		SortedSet sorted = new TreeSet();
		sorted.add(1);
		sorted.add(7);
		sorted.add(49);
		sorted.add(-13);
		Indexer indexer = new CollectionIndexer(sorted);
		CollectionIndexer.search(indexer, "Oops!");	//Search for String in Integer (Raw) Indexer
	}
	
	@Test
	public void ListIndexerTest() {
		List<String> list = new ArrayList<String>();
		list.add("Hippo");
		list.add(null);
		Indexer<String> indexer = new ListIndexer<>(list);
		assertEquals(ListIndexer.search(indexer, null), 1);
		/*
		list.add("Hippo");
		list.add("Rhino");
		list.add("Fox");
		list.add("Cat");
		Indexer<String> indexer = new ListIndexer<>(list);
		assertEquals(ListIndexer.search(indexer, "Rhino"), 1);
		assertEquals(ListIndexer.search(indexer, "Hippo"), 0);
		assertEquals(ListIndexer.search(indexer, "Fox"), 2);
		assertEquals(ListIndexer.search(indexer, "Cat"), 3);
		*/
	}
	
}
