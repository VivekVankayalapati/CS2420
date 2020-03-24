package assign09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> implements Map<K, V>
{
	private ArrayList<LinkedList<MapEntry<K, V>>> table;
	private int size;
	// private int capacity?
	
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
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(V value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MapEntry<K, V>> entries()
	{
		return this.table;
	}

	@Override
	public V get(K key)
	{
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
		if (containsKey(key) == false)
		{
			MapEntry<K, V> entry = new MapEntry<K, V>(key, value);
			table.add(entry);
			
			size++;
			
			return value;
		}
		else
		{
			// Get MapEntry, modify value
			
			return null;
		}
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size()
	{
		return this.size;
	}
}