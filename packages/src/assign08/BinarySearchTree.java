package assign08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type>
{

    BinaryNode<Type> firstNode;
    int size;

    public BinarySearchTree ()
    {
         firstNode = new BinaryNode<Type>(null);
         size = 0;
    }

    @Override
    public boolean add (Type item)
    {
        if(insert(this.firstNode,item))
        {
            size++;
            return true;
        }
       
        return false;
    }

    private boolean insert (BinaryNode<Type> node, Type item)
    {
        if (node == null)
        {
            node = new BinaryNode<Type>(item);
            return true;
        }

        if (item.compareTo(node.getData()) < 0)
        {
            insert(node.getLeftChild(),item);
        }
        else if (item.compareTo(node.getData()) > 0)
        {
            insert(node.getRightChild(),item);
            
        }
    
        return false;

    }

    @Override
    public boolean addAll (Collection<? extends Type> items)
    {
        Iterator<? extends Type> i = items.iterator();
        
        while (i.hasNext())
        {
        	boolean ifAdded = add(i.next());
        	
        	if (!ifAdded)
        	{
        		return false;
        	}
        }
        
        return true;
    }

    @Override
    public void clear ()
    {
        this.firstNode = null;
        this.size = 0;
    }

    @Override
    public boolean contains (Type item)
    {
        return search(this.firstNode, item);
    }
    
    private boolean search (BinaryNode<Type> node, Type item)
    {
    	if (item.compareTo(node.getData()) == 0)
    	{
    		return true;
    	}
    	
    	if (item.compareTo(node.getData()) < 0)
    	{
    		search(node.getLeftChild(), item);
    	}
    	
    	if (item.compareTo(node.getData()) < 0)
    	{
    		search(node.getRightChild(), item);
    	}
    	
    	return false;
    }

    @Override
    public boolean containsAll (Collection<? extends Type> items)
    {
    	Iterator<? extends Type> i = items.iterator();
        
        while (i.hasNext())
        {
        	boolean doesContain = contains(i.next());
        	
        	if (!doesContain)
        	{
        		return false;
        	}
        }
        
        return true;
    }

    @Override
    public Type first () throws NoSuchElementException
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        return firstNode.getLeftmostNode().getData();
    }

    @Override
    public boolean isEmpty ()
    {
    	if (size == 0)
    	{
    		return true;
    	}
    	
        return false;
    }

    @Override
    public Type last () throws NoSuchElementException
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        
        return firstNode.getRightmostNode().getData();
    }

    @Override
    public boolean remove (Type item)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll (Collection<? extends Type> items)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size ()
    {
        return this.size;
    }

    @Override
    public ArrayList<Type> toArrayList ()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
