package assign09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Contains unit tests for a generic HashTable
 */
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
		
		//Puts random values between 0 to 1 (exlusive) as strings. Number of values inserted requires two doublings of our HashTable
		for (int i = 0; i < 8000; i++) {
			keyList.add(Math.random() + "");
		}
		
		//Puts said values into the table
		for (int i = 0; i < 8000; i++) {
			table.put(keyList.get(i), i);
		}
		
		//Checks to see if all elements are in the table
		for (int i = 0; i < 8000; i++) {
			assertTrue(table.containsKey(keyList.get(i)));
		}
		
		//Checks whether table size is correct
		assertEquals(8000, table.size());
	}
	
	@Test
	void testGet() {
		table.put("Hello", 0);
		table.put("Bye", 1);
		table.put("Zoinks", 0);
		table.put("Scoob", 1);
		table.put("COVID", 0);
		table.put("Godzilla", 1);

		assertEquals(1, table.get("Godzilla"));
		assertEquals(0, table.get("COVID"));
		assertEquals(1, table.get("Scoob"));
		assertEquals(0, table.get("Zoinks"));
		assertEquals(1, table.get("Bye"));
		assertEquals(0, table.get("Hello"));

	}

	@Test
	void testGetNonExistent() {
		table.put("Hello", 0);
		table.put("Bye", 1);
		table.put("Zoinks", 0);
		table.put("Scoob", 1);
		table.put("COVID", 0);
		table.put("Godzilla", 1);

		assertEquals(null, table.get("NonExistent"));


	}
	
	@Test
	void testGetFromEmpty() {
		assertEquals(null,table.get("key"));
	}
	
	@Test
	void testGetEmptyHead() {
		String testString = "Hello";
		String testString2 = "World";
		int testIndex = testString.hashCode() % 100;
		int testIndex2 = testString2.hashCode() % 100;
		
		if (testIndex != testIndex2)
			table.put("Hello", 0);
		
		assertEquals(null,table.get("World"));
	}
	
	@Test
	void testRemove() {
		table.put("Hello", 0);
		table.put("Bye", 1);
		table.put("Zoinks", 0);
		table.put("Scoob", 1);
		table.put("COVID", 0);
		table.put("Godzilla", 1);

		assertEquals(1, table.remove("Scoob"));
		assertEquals(null, table.remove("Scoob"));
	}
	
	@Test
	void testRemoveFromEmpty() {
		assertEquals(null,table.remove("key"));
	}
	
	@Test
	void testRemoveEmptyHead() {
		String testString = "Hello";
		String testString2 = "World";
		int testIndex = testString.hashCode() % 100;
		int testIndex2 = testString2.hashCode() % 100;
		
		if (testIndex != testIndex2)
			table.put("Hello", 0);
		
		assertEquals(null,table.remove("World"));
	}
	
	@Test
	void testIsNotEmpty() {
		table.put("Hello", 0);
		table.put("Bye", 1);
		table.put("Zoinks", 0);
		table.put("Scoob", 1);
		table.put("COVID", 0);
		table.put("Godzilla", 1);

		assertFalse(table.isEmpty());
	}

	@Test
	void testIsEmpty() {

		assertTrue(table.isEmpty());
	}
	
	@Test
	void testClear() {
		
		table.put("Hello", 0);
		table.put("Bye", 1);
		table.put("Zoinks", 0);
		table.put("Scoob", 1);
		table.put("COVID", 0);
		table.put("Godzilla", 1);

		assertFalse(table.isEmpty());
		table.clear();
		assertTrue(table.isEmpty());
		
	}
	
	@Test
	void testClearEmpty() {
		assertTrue(table.isEmpty());
		table.clear();
		assertTrue(table.isEmpty());
	}
	
	@Test
	void testContainsSingleKey() {
		table.put("Hello", 0);
		
		assertTrue(table.containsKey("Hello"));


	}
	@Test
	void testContainsKey() {

		table.put("Hello", 0);
		table.put("Bye", 1);
		table.put("Zoinks", 0);
		table.put("Scoob", 1);
		table.put("COVID", 0);
		table.put("Godzilla", 1);

		assertTrue(table.containsKey("Zoinks"));
	}

	@Test
	void testDoesntContainsKey() {

		table.put("Hello", 0);
		table.put("Bye", 1);
		table.put("Zoinks", 0);
		table.put("Scoob", 1);
		table.put("COVID", 0);
		table.put("Godzilla", 1);

		assertFalse(table.containsKey("COVID19"));
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
		table.put("Hello", 0);
		table.put("Bye", 1);
		table.put("Zoinks", 0);
		table.put("Scoob", 1);
		table.put("COVID", 0);
		table.put("Godzilla", 1);

		assertTrue(table.containsValue(0));
	}

	@Test
	void testDoesntContainsValue() {
		table.put("Hello", 0);
		table.put("Bye", 1);
		table.put("Zoinks", 0);
		table.put("Scoob", 1);
		table.put("COVID", 0);
		table.put("Godzilla", 1);

		assertFalse(table.containsValue(5));
	}
	
	@Test
	void testContainsValueFromEmpty() {
		assertFalse(table.containsValue(4));
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
		table.put("Hello", 0);
		
		ArrayList<MapEntry<String, Integer>> expectedEntries = new ArrayList<MapEntry<String, Integer>>();
		
		expectedEntries.add(new MapEntry<String, Integer>("Hello", 0));

		
		assertTrue(table.entries().containsAll(expectedEntries));
	}
	
	@Test
	void testEmptyEntries() {
		ArrayList<MapEntry<String, Integer>> expectedEntries = new ArrayList<MapEntry<String, Integer>>();
		assertTrue(table.entries().containsAll(expectedEntries));
	}
}
