package assign09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> implements Map<K, V>
{
	private ArrayList<LinkedList<MapEntry<K, V>>> table;
	private int size;
	private int capacity = 50;
	
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
			if (item.getKey() == key)
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
			if (mapEntry.getValue() == value)
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
			if (item.getKey() == key)
			{
				return item.getValue();
			}
		}
		
		return null;
	}

	@Override
	public boolean isEmpty()
	{
		if (size == 0)
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
			if (item.getKey() == key) 
			{ 	
				V oldValue = item.getValue();
				item.setValue(value);
				size++;
				return oldValue;
			}
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
			if (item.getKey() == key) 
			{ 	
				V oldValue = item.getValue();
				head.remove(item);
				size--;
				return oldValue;
			}
		}

		return null;
	}

	@Override
	public int size()
	{
		return this.size;
	}
}