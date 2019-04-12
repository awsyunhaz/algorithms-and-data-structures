// class file for binary trees
import java.util.ArrayList;

public class BinTree {

  private BinTreeNode root;  // the root of the tree

  public BinTree() {
    root = null;
  }

  // add a new item to the tree so that the tree 
  // is an ordered binary tree
  public void add(int item) {
    BinTreeNode newNode = new BinTreeNode(item);

    if (root == null)
      root = newNode;
    else
      root.add(newNode);
  }  

  // find an item in the tree
  // return true is the item exists in the tree
  // return false if the item does not exist in the tree
  // IMPLEMENT THIS METHOD 
  public boolean hasItem(int item) {
    if (root == null)
    	return false;
    return root.hasItem(item);
  }
  
  // return the size of the tree
  public int size() {
    if (root == null) return 0;
    return root.size();
  }

  // return the height of the tree
  // IMPLEMENT THIS METHOD
  public int height() {
	  if (root == null) return -1;
	  return root.height();
  }

  // find the leaves of the tree
  public ArrayList<BinTreeNode> findLeaves() {
    if (root == null) return null;
    else return root.findLeaves();
  }

  // print out the tree elements in the in-order manner
  public void inOrderTraversal() {
    if (root != null) root.inOrderTraversal();

    System.out.println();
  }

  // print out the tree elements in the pre-order manner
  // IMPLEMENT THIS METHOD
  public void preOrderTraversal() {
	if (root != null) root.preOrderTraversal();

	  System.out.println();
  }

  // print out the tree elements in the post-order manner
  // IMPLEMENT THIS METHOD
  public void postOrderTraversal() {
	if (root != null) root.postOrderTraversal();

	  System.out.println();
  }
}
