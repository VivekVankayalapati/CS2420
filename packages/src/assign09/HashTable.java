package assign09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A Generic HashTable
 */
public class HashTable<K, V> implements Map<K, V>
{
	/**The backing ArrayList. Contains LinkedLists of type MapEntry */
	private ArrayList<LinkedList<MapEntry<K, V>>> table;
	/**Total number of items in the HashMap */
	private int size;
	/**Size of the backing array. Doubled whenever lambda >= 10.0 */
	private int capacity = 50;
	
	/**
	 * Constructs a HashTable
	 */
	public HashTable()
	{
		table = new ArrayList<LinkedList<MapEntry<K, V>>>();
		for(int i = 0; i < capacity; i++)
		{
			table.add(new LinkedList<MapEntry<K, V>>());
		}	   
	}
	
	@Override
	public void clear() 
	{
		this.table = new ArrayList<LinkedList<MapEntry<K, V>>>();
		this.size = 0;
	}

	@Override
	public boolean containsKey(K key)
	{		
		if (isEmpty())
		{
			return false;
		}
		
		LinkedList<MapEntry<K, V>> head = head(key);
		
		if (head.size() == 0)
		{
			return false;
		}
		
		for (MapEntry<K,V> item : head)
		{
			if (item.getKey().equals(key))
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean containsValue(V value)
	{
		if (isEmpty())
		{
			return false;
		}
		
		List<MapEntry<K, V>> entries = entries();
		
		for (MapEntry<K,V> mapEntry : entries)
		{
			if (mapEntry.getValue().equals(value))
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public List<MapEntry<K, V>> entries()
	{	
		ArrayList<MapEntry<K,V>> entries = new ArrayList<>();
		for (LinkedList<MapEntry<K,V>> link : this.table)
		{
			for (MapEntry<K,V> mapEntry : link)
			{
				entries.add(mapEntry);
			}
		}

		return entries;
	}

	@Override
	public V get(K key)
	{
		if (!containsKey(key))
		{
			return null;
		}
		
		LinkedList<MapEntry<K, V>> head = head(key);
		
		for (MapEntry<K,V> item : head)
		{
			if (item.getKey().equals(key))
			{
				return item.getValue();
			}
		}
		
		return null;
	}

	@Override
	public boolean isEmpty()
	{
		return (this.size == 0);
	}

	@Override
	public V put(K key, V value)
	{
		LinkedList<MapEntry<K, V>> head = head(key);
		
		if (containsKey(key) == false)
		{
			head.add(new MapEntry<K,V>(key, value));
			size++;
			return null;
		}
		
		// Check if key is already present 
		//Interate through the LinkedList
		for (MapEntry<K,V> item : head)
		{ 	
			if (item.getKey().equals(key)) 
			{ 	
				V oldValue = item.getValue();
				item.setValue(value); //No need to increment size
				return oldValue;
			}
		}

		if ((this.size)/(double)this.table.size() >= 10.0) 
        {
			resize(); //Resizes and rehashes
		}
		return null;
	}

	@Override
	public V remove(K key)
	{
		
		LinkedList<MapEntry<K, V>> head = head(key);
		
		if (containsKey(key) == false)
		{
			return null;
		}
		
		for (MapEntry<K,V> item : head)
		{ 	
			if (item.getKey().equals(key)) 
			{ 	
				V oldValue = item.getValue();
				head.remove(item);
				size--;
				return oldValue;
			}
		}

		return null;
	}

	/**
	 * Resizes and rehashes whenever lambda >= 10.0
	 */
	private void resize()
	{
		
		//Sketch
		//Overload put to take in MapEntry 
		//Create a new table of the appropirate size O(table length)
		//Using the list method, add the MapEntries using the overloaded put o(table length/2)
		//Overall behavior of resize is O(N) amortized over the calls to put

		// If load factor goes beyond threshold, then 
        // double hash table size 
		this.capacity *= 2;
		for(int size= this.table.size(); size < capacity; size++)
			this.table.add(new LinkedList<MapEntry<K, V>>());
		
			
		//Insert rehashing here


	}

	@Override
	public int size()
	{
		return this.size;
	}

	/**
	 * Gets the LinkedList based on the key's hashcode
	 * @param key
	 * @return LinkedList
	 */
	private LinkedList<MapEntry<K,V>> head(K key)
	{
		int hashCode = key.hashCode() % this.capacity;
		return this.table.get(hashCode);
	}


}