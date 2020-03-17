package assign08;

/**
 * Represents a generically-typed binary tree node. Each binary node contains data, a reference to the left child, and a
 * reference to the right child.
 * 
 * @author Erin Parker and Brady Hartog and Vivek Vankayalapati
 * @version March 6, 2020
 */
public class BinaryNode<Type>
{

    private Type data;
    
    private BinaryNode<Type> parent;

    private BinaryNode<Type> leftChild;

    private BinaryNode<Type> rightChild;

    public BinaryNode (Type data, BinaryNode<Type> parent, BinaryNode<Type> leftChild, BinaryNode<Type> rightChild)
    {
        this.data = data;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BinaryNode (Type data, BinaryNode<Type> parent)
    {
        this(data, parent, null, null);
    }

    /**
     * @return the node data
     */
    public Type getData ()
    {
        return data;
    }

    /**
     * @param data - the node data to be set
     */
    public void setData (Type data)
    {
        this.data = data;
    }
    
    /**
     * @return reference to the parent node
     */
    public BinaryNode<Type> getParent ()
    {
    	return parent;
    }
    
    /**
     * @param parent - reference to the parent node to be set
     */
    public void setParent (BinaryNode<Type> parent)
    {
    	this.parent = parent;
    }

    /**
     * @return reference to the left child node
     */
    public BinaryNode<Type> getLeftChild ()
    {
        return leftChild;
    }

    /**
     * @param leftChild - reference of the left child node to be set
     */
    public void setLeftChild (BinaryNode<Type> leftChild)
    {
        this.leftChild = leftChild;
    }

    /**
     * @return reference to the right child node
     */
    public BinaryNode<Type> getRightChild ()
    {
        return this.rightChild; 
    }

    /**
     * @param rightChild - reference of the right child node to be set
     */
    public void setRightChild (BinaryNode<Type> rightChild)
    {
        this.rightChild = rightChild;
    }

    /**
     * @return reference to the leftmost node in the binary tree rooted at this node
     */
    public BinaryNode<Type> getLeftmostNode ()
    {
        if (this.getLeftChild() == null)
        {
            return this;
        }
        
        return this.getLeftChild().getLeftmostNode();
        
    }

    /**
     * @return reference to the rightmost node in the binary tree rooted at this node
     */
    public BinaryNode<Type> getRightmostNode ()
    {

        if (this.getRightChild() == null)
        {
            return this;
        }
        
        return this.getRightChild().getRightmostNode();
    }

    /**
     * @return the height of the binary tree rooted at this node
     * 
     *         The height of a tree is the length of the longest path to a leaf node. Consider a tree with a single node
     *         to have a height of zero.
     */
    // public int height ()  //Not sure how this method could be used
    // {
    //     return 0;
    // }
}