package assign08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type>
{

    BinaryNode<Type> firstNode;

    public BinarySearchTree ()
    {
         firstNode = new BinaryNode<Type>(null);

    }

    @Override
    public boolean add (Type item)
    {
        insert(this.firstNode,item);
        
        if (contains(item))
        {
            return true;
        }

        return false;
    }

    private void insert(BinaryNode<Type> node, Type item)
    {
        if (node == null)
        {
            node = new BinaryNode<Type>(item);

        }

        if (item.compareTo(node.getData()) < 0)
        {
            insert(node.getLeftChild(),item);
        }
        else if (item.compareTo(node.getData()) > 0)
        {
            insert(node.getRightChild(),item);
        }   
    }

    @Override
    public boolean addAll (Collection<? extends Type> items)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear ()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean contains (Type item)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll (Collection<? extends Type> items)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Type first () throws NoSuchElementException
    {
        return firstNode.getLeftmostNode().getData();
    }

    @Override
    public boolean isEmpty ()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Type last () throws NoSuchElementException
    {
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ArrayList<Type> toArrayList ()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
