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
		   table.add(new LinkedList<MapEntry<K, V>>());
	}
	
	@Override
	public void clear() {
		this.table = new ArrayList<LinkedList<MapEntry<K, V>>>();
		this.size = 0;
	}

	@Override
	public boolean containsKey(K key)
	{		
		if (this.size == 0)
		{
			return false;
		}
		
		int hashCode = key.hashCode() % this.capacity;
		LinkedList<MapEntry<K, V>> head = this.table.get(hashCode);
		
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
		if (this.size == 0)
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
		
		int hashCode = key.hashCode() % this.capacity;
		LinkedList<MapEntry<K, V>> head = this.table.get(hashCode);
		
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
		if (this.size == 0)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public V put(K key, V value)
	{
		int hashCode = key.hashCode() % this.capacity;
		LinkedList<MapEntry<K, V>> head = this.table.get(hashCode);
		
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
				item.setValue(value);
				size++;
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
		int hashCode = key.hashCode() % this.capacity;
		LinkedList<MapEntry<K, V>> head = this.table.get(hashCode);
		
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


}