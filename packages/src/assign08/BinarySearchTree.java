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
    private BinaryNode<Type> rootNode;

    private BinaryNode<Type> fakeParent;

    /**The number of items in the BinarySearchTree */
    private int size;

    /**
     * Constructs a Binary Search Tree. Defined by a root node with an inaccesible parent for edge cases and its progeny
     */
    public BinarySearchTree ()
    {
        //A null root node
         this.fakeParent = new BinaryNode<Type>(null);
         //this.rootNode.setParent(new BinaryNode<Type>(null,null,this.rootNode,null));  //Because everything traverses from the rootNode, a parent is inaccesible excepting removal
         
        this.rootNode = new  BinaryNode<Type>(null,this.fakeParent);

        this.fakeParent.setLeftChild(this.rootNode);
        
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
     * @param node
     * @param item
     */
    private boolean insert (BinaryNode<Type> node, Type item)
    {
    	if (item.compareTo(node.getData()) < 0)
        {
        	if (node.getLeftChild() == null)
        	{
        		BinaryNode<Type> newNode = new BinaryNode<>(item, node);
        		
        		node.setLeftChild(newNode);
        		
        		return true;
        	}
        	else
        	{
        		return insert(node.getLeftChild(), item);
        	}
        }

        else if (item.compareTo(node.getData()) > 0)
        {
        	if (node.getRightChild() == null)
        	{
        		BinaryNode<Type> newNode = new BinaryNode<>(item, node);
        		
        		node.setRightChild(newNode);
        		
        		return true;
        	}
        	else
        	{
        		return insert(node.getRightChild(), item);
        	}
        }
    
        return false;
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
        this.rootNode.setData(null);
        this.rootNode.setRightChild(null);
        this.rootNode.setLeftChild(null);
        this.size = 0;
    }

    @Override
    public boolean contains (Type item)
    {
        BinaryNode<Type> node = contains(this.rootNode, item);
        
        return (node != null);
    }

    private BinaryNode<Type> contains (BinaryNode<Type> node, Type item)
    {
        int compare = item.compareTo(node.getData());
        if (node == null || compare == 0)
        {
            return node;
        }

        

        if (compare < 0)
    	{
    		return contains(node.getLeftChild(), item);
    	}
 
    	return contains(node.getRightChild(), item);
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
    	if (this.size == 0)
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
        
        if (initialSize == 0)
        { 
            return false;
        }

        else
        {
            findAndRemove(rootNode, item);
            
            //deleteRec(rootNode, item);
        }
    	
    	if (size() == initialSize - 1)
    	{
    		return true;
    	}
    	
    	return false;
    }

    /* A recursive function to insert a new key in BST */
    private BinaryNode<Type> deleteRec(BinaryNode<Type> root, Type item) 
    { 
        /* Base Case: If the tree is empty */
        if (root == null)  return root; 
  
        /* Otherwise, recur down the tree */
        if (item.compareTo(root.getData()) < 0 ) 
            root.setLeftChild(deleteRec(root.getLeftChild(), item)); 
        else if (item.compareTo(root.getData()) > 0) 
            root.setRightChild(deleteRec(root.getRightChild(), root.getData())); 
  
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (root.getLeftChild() == null) 
                return root.getRightChild(); 
            else if (root.getRightChild() == null) 
                return root.getLeftChild();
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.setData(root.getRightChild().getLeftmostNode().getData());
  
            // Delete the inorder successor 
            root.setRightChild(deleteRec(root.getRightChild(), item)); 
        } 
  
        return root; 
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
    private void findAndRemove (BinaryNode<Type> node, Type item) // Test comment
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
                Type leftChildData = node.getLeftChild().getData();
                
                node.setData(leftChildData);
                
                node.getLeftChild().setParent(node.getParent());
                
                if (node.getIsLeft())
                {
            		node.getParent().setLeftChild(node.getLeftChild());
                }
                else
                {
                	node.getParent().setRightChild(node.getLeftChild());
                }
                
                size--;
    		}
    		else if (node.getLeftChild() == null)
    		{
    			Type rightChildData = node.getRightChild().getData();
                
                node.setData(rightChildData);
                
                node.getRightChild().setParent(node.getParent());
                
                if (node.getIsLeft())
                {
            		node.getParent().setLeftChild(node.getRightChild());
                }
                else
                {
                	node.getParent().setRightChild(node.getRightChild());
                }
                
                size--;
    		}
    		else
    		{
    			BinaryNode<Type> minNode = node.getRightChild().getLeftmostNode();
    			
				Type minNodeData = minNode.getData();
				
				remove(minNodeData);
				
				node.setData(minNodeData);
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

        return (removeCounter > 0);
    }

    @Override
    public int size ()  //complete
    {
        return this.size;
    }

    @Override
    public ArrayList<Type> toArrayList () //complete
    {
        ArrayList<Type> list = new ArrayList<Type>();
        
	    if (size != 0)
	    {
	    	listing(this.rootNode,list);
	    }

        return list;
    }

    private void listing (BinaryNode<Type> node,ArrayList<Type> list)
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
