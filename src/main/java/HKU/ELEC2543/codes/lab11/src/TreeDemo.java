import java.util.ArrayList;

public class TreeDemo {

  public static void main(String[] args) {
    BinTree tree = new BinTree();

    tree.add(6);
    tree.add(4);
    tree.add(5);
    tree.add(9);
    tree.add(8);
    tree.add(10);
    tree.add(1);
    tree.add(11);

    
    System.out.println("This size of the tree is : " + tree.size());
    System.out.println("This height of the tree is : " + tree.height());
    System.out.print("In-order travesal : ");
    tree.inOrderTraversal();
    System.out.print("Pre-order travesal : ");
    tree.preOrderTraversal();
    System.out.print("Post-order travesal : ");
    tree.postOrderTraversal();


    // print out all the leaves on this tree
    System.out.print("The leaves of the tree are : ");
    ArrayList<BinTreeNode> leaves = tree.findLeaves();
    for (int i = 0; i < leaves.size(); i++) {
      System.out.print(leaves.get(i).getItem() + " ");
    }
    System.out.println();

    // for each leaf, print out its sibling
    for (int i = 0; i < leaves.size(); i++) {
      BinTreeNode sib = leaves.get(i).mySibling();

      if (sib == null)
        System.out.println(leaves.get(i).getItem() + " does not have a sibling");
      else
        System.out.println(leaves.get(i).getItem() + " has sibling " + sib.getItem());
    }
  }
}
