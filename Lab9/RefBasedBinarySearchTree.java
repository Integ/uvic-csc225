import java.lang.Math;
/*
 * RefBasedBinarySearchTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinarySearchTree extends RefBasedBinaryTree {
    public void insert(Integer value){
        root = insert(root, value);
    }
    // not a balanced insert
    private TreeNode insert(TreeNode root, Integer value) {
        if (root == null) { 
            root = new TreeNode(value);
            return root; 
        }
        if (value < root.data) {
            root.setLeft(insert(root.getLeft(), value));
        } else if (value > root.data) {
            root.setRight(insert(root.getRight(), value));
        }
        return root;
    }

/** Method name: find
  * Purpose: determines whether val is in this BinaryTree
  * Parameters: int val
  * Returns: boolean –true if val is found, false otherwise
  */
    public boolean find(int val) {
        return findRec(root, val);
    }

    private boolean findRec(TreeNode current, int val) { 
        if (current == null)
            return false;

        if (current.getValue() == val)
            return true;

        return (current.getValue() > val) ? findRec(current.getLeft(), val) : findRec(current.getRight(), val); 
    }


/** Method name: getMax
 * Purpose: gets and returns the largestvalue in this BinaryTree
 * Parameters: none
 * Throws: TreeEmptyException if called on an empty tree
 * Returns: int –the largestvalue
 */
    public int getMax() throws TreeEmptyException {
        if(root == null) {
            throw new TreeEmptyException();
        }
        TreeNode current = root;
        while (current.getRight() != null)
            current = current.right;
        return (current.data);
    }

/** Method name: levelOrder
 * Purpose: prints all values in this BinaryTree in a level order
 * Parameters: none
 * Returns: nothing
 */
    public void levelOrder() {
        int h = height(root); 
        int i; 
        for (i=0; i<=h; i++) 
            printGivenLevel(root, i); 
    }

    private void printGivenLevel (TreeNode root ,int level) { 
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.getValue() + " "); 
        else if (level > 0) { 
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        } 
    } 

    public static void main(String[] args) throws TreeEmptyException {
        // use these trees to test the methods you will implement
        RefBasedBinarySearchTree emptyTree = new RefBasedBinarySearchTree();
        RefBasedBinarySearchTree myTree = new RefBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);

        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();

        System.out.println("toString\n" + myTree);

        System.out.println("sum():" + myTree.sum());
        System.out.println("find(7):" + myTree.find(7));
        System.out.println("find(3):" + myTree.find(3));
        System.out.println("max():" + myTree.getMax());
        myTree.levelOrder();
    }
}
