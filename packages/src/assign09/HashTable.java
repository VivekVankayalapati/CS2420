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

	/**Size of the backing array. Doubled whenever lambda is reached */
	private int capacity;

	/**Number of collisions as a result of put method */
	private int collisions;

	/**The maximum allowed lambda */
	private double lambda;
	
	/**
	 * Constructs a HashTable
	 */
	public HashTable()
	{
		this.size = 0;
		this.capacity = 100;
		this.collisions = 0;
		this.lambda = 10.0;
		this.table = new ArrayList<LinkedList<MapEntry<K, V>>>();

		//Fills table to capacity with empty linked lists
		for(int i = 0; i < capacity; i++)
		{
			table.add(new LinkedList<MapEntry<K, V>>());
		}	   
	}
	
	@Override
	public void clear() 
	{	
		//Emptys table via instantion
		this.table = new ArrayList<LinkedList<MapEntry<K, V>>>();

		//Fills table to capacity with empty linked lists
		for(int i = 0; i < capacity; i++)
		{
			table.add(new LinkedList<MapEntry<K, V>>());
		}

		//Resets size and the number of collisions
		this.size = 0;
		this.collisions=0;
	}

	@Override
	public boolean containsKey(K key)
	{	
		//If the HashTable is empty	
		if (isEmpty())
		{
			return false;
		}
		
		//Gets the LinkedList corresponding the the absolute truncated hashCode from the key
		LinkedList<MapEntry<K, V>> head = head(key);
		
		//If the LinkedList is empty
		if (head.size() == 0)
		{
			return false;
		}
		

		//Searches the LinkedList
		for (MapEntry<K,V> item : head)
		{	
			//If the key is found
			if (item.getKey().equals(key))
			{
				return true;
			}
		}
		
		//If the key is not found
		return false;
	}

	@Override
	public boolean containsValue(V value)
	{	
		//If the HashMap is empty
		if (isEmpty())
		{
			return false;
		}
		
		//Stores the MapEntries
		List<MapEntry<K, V>> entries = entries();
		
		//For every MapEntry
		for (MapEntry<K,V> mapEntry : entries)
		{	
			//If value is found
			if (mapEntry.getValue().equals(value))
			{
				return true;
			}
		}
		
		//If value is not found
		return false;
	}

	@Override
	public List<MapEntry<K, V>> entries()
	{	
		//Stores MapEntries
		ArrayList<MapEntry<K,V>> entries = new ArrayList<>();

		//For every LinkedList int the HashTable
		for (LinkedList<MapEntry<K,V>> link : this.table)
		{
			//For every MapEntry in the LinkedList
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
		//Gets the LinkedList corresponding the the absolute truncated hashCode from the key
		LinkedList<MapEntry<K, V>> head = head(key);

		//If the LinkedList is empty
		if (head.size() == 0)
		{
			return null;
		}
		
		
		//For every MapEntry
		for (MapEntry<K,V> item : head)
		{
			//If key is found
			if (item.getKey().equals(key))
			{
				return item.getValue();
			}
		}
		
		//If key is not found
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
		
		//If LinkedList is empty, add a new MapEntry
		if (head.size() == 0)
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
				return oldValue;
			}
			else
			{	
				//Only used in timing, as per Dr. Parker's recommendation from Q @307
				this.collisions++;
			}
		}

		//If no duplicate keys are found
		head.add(new MapEntry<K,V>(key, value));
		size++;
		
		//Resize condition
		if ((this.size)/(double)this.table.size() >= this.lambda) 
        {
			resize(); //Resizes and rehashes
		}

		return null;
	}

	@Override
	public V remove(K key)
	{
		//Gets the LinkedList corresponding the the absolute truncated hashCode from the key
		LinkedList<MapEntry<K, V>> head = head(key);
		

		//If the LinkedList is empty
		if (head.size() == 0)
		{
			return null;
		}
		
		//Iterating through the LinkedList
		for (MapEntry<K,V> item : head)
		{ 	
			if (item.getKey().equals(key)) 
			{ 	
				//Deletion
				V oldValue = item.getValue();
				head.remove(item);
				size--;
				return oldValue;
			}
		}

		//If nothing found
		return null;
	}

	/**
	 * Resizes and rehashes whenever lambda >= 10.0
	 */
	private void resize()
	{
		//Doubles capacity
		this.capacity *= 2;
		
		//Gets old MapEntries
		List<MapEntry<K,V>> oldList = entries();

		//Resizes
		clear();
		
		//Rehashes
		for (MapEntry<K,V> entry : oldList)
		{
			put(entry.getKey(),entry.getValue());
		}
	}

	@Override
	public int size()
	{
		return this.size;
	}

	/**
	 * Helper method for getting the number of collisions in our HashTable.
	 * Only used in timing, as per Dr. Parker's recommendation from Q @307
	 */
	public int collisions()
	{
		return this.collisions;
	}

	/**
	 * Sets the maximum lambda 
	 * Used only in timing
	 * @param lambda
	 */
	public void setLambda(double lambda)
	{
		this.lambda = lambda;
	}

	/**
	 * Gets the maximum lambda
	 * Used only in timing
	 * @return
	 */
	public double getLambda()
	{
		return this.lambda;
	}


	/**
	 * Gets the LinkedList based on the key's hashcode
	 * @param key
	 * @return LinkedList
	 */
	private LinkedList<MapEntry<K,V>> head(K key)
	{
		//Gets the absolute value of the hascode modded by the capacity
		int hashCode = Math.abs(key.hashCode()) % this.capacity;

		return this.table.get(hashCode);
	}


}