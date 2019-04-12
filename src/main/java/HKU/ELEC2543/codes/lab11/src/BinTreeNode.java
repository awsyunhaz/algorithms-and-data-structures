// class file for binary tree nodes
import java.util.ArrayList;

public class BinTreeNode {

  private BinTreeNode parent, left, right;
  private int item;  

  public BinTreeNode(int item) {
    this.item = item;
    parent = left = right = null;
  }

  public int getItem() {
    return item;
  }

  // add the new tree node to the tree
  // the resultant tree is an ordered binary tree
  public void add(BinTreeNode newNode) {

    // add in the left subtree
    // if the item added is smaller than or equal to this node
    if (newNode.item <= item) {
       if (left == null) { // add as the left child
	  newNode.parent = this;
	  left = newNode;
       }
       else {
	  left.add(newNode);
       }
    } 

    // add in the right subtree
    // if the item added is larger this node
    else {
       if (right == null) { // add as the right child
          newNode.parent = this;
          right = newNode;
       }
       else {
          right.add(newNode);
       }
    }
  }

  // return the sibling of this node if it exists
  // return null if there is no sibling
  // IMPLEMENT THIS METHOD
  public BinTreeNode mySibling() {
	  if (parent == null)
		  return null;
	  if (isLeftChild()){
		  if (parent.right == null)
			  return null;
		  else 
			  return parent.right;
	  }
	  if (isRightChild()){
		  if (parent.left == null)
			  return null;
		  else 
			  return parent.left;
	  }
	  
	  return null;
		  
  }

  // return the list of leaves of the subtree rooted at this node
  // IMPLEMENT THIS METHOD 
  public ArrayList<BinTreeNode> findLeaves() {
    ArrayList<BinTreeNode> leaves = new ArrayList<BinTreeNode>();
    if (left==null && right==null)
    	leaves.add(this);
    if (left!=null)
    	leaves.addAll(left.findLeaves());
    if (right!=null)
    	leaves.addAll(right.findLeaves());
    
    return leaves;
  }

  private boolean isRoot() {
    return (parent == null);
  }

  private boolean isLeftChild() {
    if (parent == null) return false;

    return (parent.left == this);
  }
  
  private boolean isRightChild() {
	    if (parent == null) return false;

	    return (parent.right == this);
	  }

  // return the size of subtree rooted at this node
  public int size() {
    int leftSize = 0;  // size of the subtree rooted at the left child
    int rightSize = 0; // size of the subtree rooted at the right child
    
    if (left != null) leftSize = left.size();

    if (right != null) rightSize = right.size();

    return leftSize + rightSize + 1;
  }
  
  //return the height of subtree rooted at this node
  public int height() {
    int leftHeight = 0;  // height of the subtree rooted at the left child
    int rightHeight = 0; // height of the subtree rooted at the right child
   
    if (left != null) leftHeight = left.height();
    if (right != null) rightHeight = right.height();
    
    if (left==null && right==null)
    	return 0;
    else
    	return Math.max(leftHeight, rightHeight) + 1;
 }
  
  //return true if the item exists in the tree rooted at this note; false otherwise
  public boolean hasItem(int item) {

	  if (item<=getItem()){
		  if (left==null)
			  return false;
		  else
			  return left.hasItem(item);
	  }
	  else{
		  if (left==null)
			  return false;
		  else
			  return right.hasItem(item);
	  }
 }

  // in-order traversal 
  public void inOrderTraversal() {
    if (left != null) left.inOrderTraversal();

    System.out.print(item + " ");

    if (right != null) right.inOrderTraversal();
  }
  
  public void preOrderTraversal() {
	    System.out.print(item + " ");
	    
	    if (left != null) left.preOrderTraversal();

	    if (right != null) right.preOrderTraversal();
  }
  
  public void postOrderTraversal() {
	    if (left != null) left.postOrderTraversal();

	    if (right != null) right.postOrderTraversal();
	    
	    System.out.print(item + " ");
  }


}


