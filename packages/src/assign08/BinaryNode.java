package assign08;

/**
 * Represents a generically-typed binary tree node. Each binary node contains data, a reference to the left child, and a
 * reference to the right child.
 * 
 * @author Erin Parker and ??
 * @version March 6, 2020
 */
public class BinaryNode<Type>
{

    private Type data;

    private BinaryNode<Type> leftChild;

    private BinaryNode<Type> rightChild;

    public BinaryNode (Type data, BinaryNode<Type> leftChild, BinaryNode<Type> rightChild)
    {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BinaryNode (Type data)
    {
        this(data, null, null);
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

//    public BinaryNode<Type> getLeftmostNode (BinaryNode<Type> leftNode)
//    {
//
//        if (leftNode == null)
//        {
//            return null;
//        }
//        if (leftNode.getLeftChild() == null)
//        {
//            return leftNode;
//        }
//
//        return getRightmostNode(leftNode.getLeftChild());
//
//    }

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

//    public BinaryNode<Type> getRightmostNode (BinaryNode<Type> rightNode)
//    {
//
//        if (rightNode == null)
//        {
//            return null;
//        }
//        if (rightNode.getRightChild() == null)
//        {
//            return rightNode;
//        }
//
//        return getRightmostNode(rightNode.getRightChild());
//
//    }

    /**
     * @return the height of the binary tree rooted at this node
     * 
     *         The height of a tree is the length of the longest path to a leaf node. Consider a tree with a single node
     *         to have a height of zero.
     */
    // public int height ()
    // {

    //     return Math.max(height(this.getLeftChild()), height(this.getRightChild()));

    // }

    // public int height (BinaryNode<Type> node)
    // {
    //     if (this.getLeftChild() == null || this.getRightChild() == null)
    //     {
    //         return 0;
    //     }
    //     else
    //     {
    //         /* compute the depth of each subtree */
    //         int lDepth = height(node.getLeftChild());
    //         int rDepth = height(node.getRightChild());

    //         /* use the larger one */
    //         if (lDepth > rDepth)
    //             return (lDepth);
    //         else
    //             return (rDepth);
    //     }
    // }
}