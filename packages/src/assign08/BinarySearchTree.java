package assign08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;



/**
 * A Generic Binary Tree
 * @author Brady Hartog and Vivek Vankayalapati
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type>
{

    /**The root node */
    BinaryNode<Type> rootNode;

    /**The number of items in the BinarySearchTree */
    int size;

    /**
     * Constructs a Binary Search Tree. Defined by a root node with no parent and its progeny
     */
    public BinarySearchTree ()
    {
        //A null root node
         this.rootNode = new BinaryNode<Type>(null);
         size = 0;
    }

    @Override
    public boolean add (Type item)
    {
        //Generates the root node
        if (this.rootNode.getData() == null)
        {
        	this.rootNode.setData(item);
        	size++;
        	return true;
        }
        
        //Run if insertion was successful
    	if (insert(this.rootNode,item))
        {
            size++;
            return true;
        }
       
        return false;
    }
    
    /**
     * Helper method for add. Performs the insertion. 
     * Insertion is ordered but misshapen
     * @param node
     * @param item
     */
    private boolean insert (BinaryNode<Type> node, Type item)
    {
    	boolean isInserted = false;
    	
        if (item.compareTo(node.getData()) < 0)
        {
        	if (node.getLeftChild() == null)
        	{
        		BinaryNode<Type> newNode = new BinaryNode<>(item, node);
        		
        		node.setLeftChild(newNode);
        		
        		isInserted = true;
        	}
        	else
        	{
        		isInserted = insert(node.getLeftChild(), item);
        	}
        }

        else if (item.compareTo(node.getData()) > 0)
        {
        	if (node.getRightChild() == null)
        	{
        		BinaryNode<Type> newNode = new BinaryNode<>(item, node);
        		
        		node.setRightChild(newNode);
        		
        		isInserted = true;
        	}
        	else
        	{
        		isInserted = insert(node.getRightChild(), item);
        	}
        }
    
        return isInserted;
    }

    @Override
    public boolean addAll (Collection<? extends Type> items)
    {
        Iterator<? extends Type> i = items.iterator();

        int successCounter = 0;

        while (i.hasNext())
        {
        	boolean ifAdded = add(i.next());
        	
            if (ifAdded)
            {
                successCounter++;
            }
        
        }

        if(successCounter>0)
        {
            return true;
        }

        return false;
    }

    @Override
    public void clear ()
    {
        this.rootNode = null;   

        // this.rootNode.setData(null);
        // this.rootNode.setLeftChild(null);
        // this.rootNode.setRightChild(null);

        this.size = 0;
    }

    @Override
    public boolean contains (Type item)
    {
        return search(this.rootNode, item);
    }
    
    private boolean search (BinaryNode<Type> node, Type item)
    {
    	if (item.compareTo(node.getData()) == 0)
    	{
    		return true;
    	}
    	
        else if (item.compareTo(node.getData()) < 0)
    	{
    		search(node.getLeftChild(), item);
    	}
    	
    	else if (item.compareTo(node.getData()) < 0)
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

        return this.rootNode.getLeftmostNode().getData();
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
        
        return this.rootNode.getRightmostNode().getData();
    }

    @Override
    public boolean remove (Type item) //Incomplete
    {
    	int initialSize = size();
    	
    	findAndRemove(rootNode, item);
    	
    	if (size() == initialSize - 1)
    	{
    		return true;
    	}
    	
    	return false;
    }

    private void delete(BinaryNode<Type> node)
    {
        if (node.getIsLeft())
        {
            node.getParent().setLeftChild(null);
        }
        else
        {
            node.getParent().setRightChild(null);
        }
    }
    
    /**
     * Helper method for remove. Performs the removal.
     * @param node
     * @param item
     */
    private void findAndRemove (BinaryNode<Type> node, Type item)
    {
    	if (item.compareTo(node.getData()) == 0)
    	{
    		if (node.getLeftChild() == null && node.getRightChild() == null)
    		{
                delete(node);
                size--;
    		}
    		else if (node.getRightChild() == null)
    		{
    			node.getParent().setLeftChild(node.getLeftChild());
    			size--;
    		}
    		else if (node.getLeftChild() == null)
    		{
    			node.getParent().setRightChild(node.getRightChild());
    			size--;
    		}
    		else
    		{
    			BinaryNode<Type> minNode = node.getRightChild().getLeftmostNode();
    			
    			minNode.getParent().setLeftChild(null);
    			
    			minNode.setParent(node.getParent());
    			minNode.setLeftChild(node.getLeftChild());
    			minNode.setRightChild(node.getRightChild());
    			
    			node.getParent().setLeftChild(minNode);
    			node.getLeftChild().setParent(minNode);
    			node.getRightChild().setParent(minNode);
    			
    			size--;
    		}
    	}
    	
    	else if (item.compareTo(node.getData()) < 0)
    	{
    		findAndRemove(node.getLeftChild(), item);
    	}
    	
    	else if (item.compareTo(node.getData()) > 0)
    	{
    		findAndRemove(node.getRightChild(), item);
    	}
    }

    @Override
    public boolean removeAll (Collection<? extends Type> items)
    {
        Iterator<? extends Type> i = items.iterator();

        int removeCounter = 0;

        while (i.hasNext())
        {
        	boolean ifRemoved = remove(i.next());
        	
            if (ifRemoved)
            {
                removeCounter++;
            }
        
        }

        if(removeCounter>0)
        {
            return true;
        }

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
        ArrayList<Type> list = new ArrayList<Type>();
        
        listing(this.rootNode,list);

        return list;
    	
        
    }

    public void listing (BinaryNode<Type> node,ArrayList<Type> list)
    {
        //do a recursive traversal of the subtree on the right
        if(node.getLeftChild() != null)
            listing(node.getLeftChild(),list);

        // "visit" this node
        list.add(node.getData());

        // do a recursive traversal of the subtree on the right
        if(node.getRightChild() != null)
            listing(node.getRightChild(),list);
    }

}
