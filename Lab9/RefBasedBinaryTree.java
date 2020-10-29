import java.lang.Math;
import java.util.LinkedList;
/*
 * RefBasedBinaryTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinaryTree implements BinaryTree {
    protected TreeNode root;

    public RefBasedBinaryTree() {
        this.root = null;
    }

    public void insert(Integer value){
        if (root==null)
            root = new TreeNode(value);
        else
            insert(null, root, value);

    }
    // not a balanced insert
    private void insert(TreeNode parent, TreeNode t, Integer value) {
        if (t==null) {
            if(parent.getLeft()==null) {
                parent.setLeft(new TreeNode(value));
			} else {
                parent.setRight(new TreeNode(value));
			}
        }  else {
            int htLeft = height(t.getLeft());
            int htRight = height(t.getRight());
            if (htLeft>htRight) {
                insert(t, t.getRight(), value);
			} else {
                insert(t, t.getLeft(), value);
			}
        }
    }

    public int height(TreeNode t) {
        if (t==null) {
            return -1;
		} else {
            int highest = Math.max(height(t.getLeft()), height(t.getRight()));
            return 1 + highest;
        }
    }

    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following an in-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }

    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following an in-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void inOrder(TreeNode t){
        if (t==null)
            return;
        else {
            inOrder(t.getLeft());
            System.out.print(t.getValue() + " ");
            inOrder(t.getRight());
        }
    }

    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a pre-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }

    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a pre-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void preOrder(TreeNode t){
        if (t==null)
            return;
        else {
            System.out.print(t.getValue() + " ");
            preOrder(t.getLeft());
            preOrder(t.getRight());
        }
    }

    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a post-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }

    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a post-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void postOrder(TreeNode t){
        if (t==null)
            return;
        else {
            postOrder(t.getLeft());
            postOrder(t.getRight());
            System.out.print(t.getValue() + " ");
        }
    }

    /*
     * Purpose: returns a String reprensentation of this BinaryTree
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        return toString(root);
    }

    private String toString(TreeNode t) {
        if(t==null)
            return "";
        else {
            String s = "";

            s += toString(t.getLeft());
            s += t.getValue() + " ";
            s += toString(t.getRight());

            return s;
        }
    }

/** Method name: sum
 * Purpose: computes the sum of all elements in this BinaryTree
 * Parameters: none
 * Returns: int –the sum
 */
    public int sum() {
        return sum(root);
    }

    private int sum(TreeNode t) {
        if(t == null) {
            return 0;
        } else {
            int i = 0;
            i = t.getValue() + sum(t.getLeft()) + sum(t.getRight());
            return i;
        }
    }

/** Method name: find
  * Purpose: determines whether val is in this BinaryTree
  * Parameters: int val
  * Returns: boolean –true if val is found, false otherwise
  */
    public boolean find(int val) {
        return find(root, val);
    }

    private boolean find(TreeNode t, int val) {
        if(t == null) {
            return false;
        }
        if(t.getValue() == val) {
            return true;
        } else {
            return find(t.getLeft(), val) || find(t.getRight(), val);
        }
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
        } else {
            return getMax(root, root.getValue());
        }
    }

    private int getMax(TreeNode t, int max) {
        if(t==null) {
            return max;
        } else {
            max = Math.max(t.getValue(), max);
            max = Math.max(getMax(t.getLeft(), max), getMax(t.getRight(), max));
            return max;
        }
    }

/** Method name: levelOrder
 * Purpose: prints all values in this BinaryTree in a level order
 * Parameters: none
 * Returns: nothing
 */
    public void levelOrder() {
        String s = "";
        for (int i=height(root); i>=0; i--) {
            s += levelOrder(root, i) + '\n';
        }
        System.out.println(s);
    }

    private String levelOrder(TreeNode t, int level) {
        if (t == null) {
            return "";
        }
        if (height(t) == level) {
            return Integer.toString(t.getValue()) + ' ';
        } else {
            return levelOrder(t.getLeft(), level) + levelOrder(t.getRight(), level);
        }
    }

    public static void main(String[] args) throws TreeEmptyException {
        // use these trees to test the methods you will implement in Part II
        RefBasedBinaryTree emptyTree = new RefBasedBinaryTree();
        RefBasedBinaryTree myTree = new RefBasedBinaryTree();
        for(int i=2; i<8; i++) {
            myTree.insert(i);
        }
        System.out.println("sum():" + myTree.sum());
        System.out.println("find(2):" + myTree.find(2));
        System.out.println("find(1):" + myTree.find(1));
        System.out.println("getMax():" + myTree.getMax());
        myTree.levelOrder();

    }

}