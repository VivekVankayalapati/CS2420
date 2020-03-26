package assign09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashTableTest {
	
	HashTable<String, Integer> table;
	
	@BeforeEach
	void setUp() {
		table = new HashTable<>();
	}
	
	@Test
	void testPut() {
		table.put("Hello", 0);
		
		assertEquals("Hello", table.entries().get(0).getKey());
		assertEquals(1, table.size());
	}
	
	@Test
	void testPutDuplicates() {
		table.put("Hello", 0);
		table.put("Hello", 0);
		
		assertEquals("Hello", table.entries().get(0).getKey());
		assertEquals(1, table.size());
	}
	
	@Test
	void testPutReplace() {
		table.put("Hello", 0);
		table.put("Hello", 1);
		
		assertEquals("Hello", table.entries().get(0).getKey());
		assertEquals(1, table.entries().get(0).getValue());
		assertEquals(1, table.size());
	}
	
	@Test
	void testPutBeyondCapacity() {
		ArrayList<String> keyList = new ArrayList<>();
		
		for (int i = 0; i < 1001; i++) {
			keyList.add(Math.random() + "");
		}
		
		for (int i = 0; i < 999; i++) {
			table.put(keyList.get(i), i);
		}
		
		table.put(keyList.get(1000), 1000);
		table.put(keyList.get(1001), 1001);
		
		for (int i = 0; i < 1001; i++) {
			assertTrue(table.containsKey(keyList.get(i)));
		}
		
		assertEquals(1001, table.size());
	}
	
	@Test
	void testGet() {
		//
	}
	
	@Test
	void testGetFromEmpty() {
		//
	}
	
	@Test
	void testGetEmptyHead() {
		//
	}
	
	@Test
	void testtestRemove() {
		//
	}
	
	@Test
	void testRemoveFromEmpty() {
		//
	}
	
	@Test
	void testRemoveEmptyHead() {
		//
	}
	
	@Test
	void testIsEmpty() {
		//
	}
	
	@Test
	void testClear() {
		//
	}
	
	@Test
	void testClearEmpty() {
		//
	}
	
	@Test
	void testContainsKey() {
		table.put("Hello", 0);
		
		assertTrue(table.containsKey("Hello"));
	}
	
	@Test
	void testContainsKeyFromEmpty() {
		assertFalse(table.containsKey("Hello"));
	}
	
	@Test
	void testContainsKeyEmptyHead() {
		String testString = "Hello";
		String testString2 = "World";
		int testIndex = testString.hashCode() % 100;
		int testIndex2 = testString2.hashCode() % 100;
		
		if (testIndex != testIndex2)
			table.put("Hello", 0);
		
		assertFalse(table.containsKey("World"));
	}
	
	@Test
	void testContainsValue() {
		//
	}
	
	@Test
	void testContainsValueFromEmpty() {
		//
	}
	
	@Test
	void testContainsValueEmptyHead() {
		//
	}
	
	@Test
	void testEntries() {
		table.put("Hello", 0);
		table.put("World", 1);
		table.put("Lorem", 2);
		
		ArrayList<MapEntry<String, Integer>> expectedEntries = new ArrayList<MapEntry<String, Integer>>();
		
		expectedEntries.add(new MapEntry<String, Integer>("Hello", 0));
		expectedEntries.add(new MapEntry<String, Integer>("World", 1));
		expectedEntries.add(new MapEntry<String, Integer>("Lorem", 2));
		
		assertTrue(table.entries().containsAll(expectedEntries));
	}
	
	@Test
	void testEntriesSingle() {
		//
	}
	
	@Test
	void testEmpty() {
		//
	}
}
