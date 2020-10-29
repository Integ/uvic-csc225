import java.lang.Math;
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
        insert(null, root, value);
    }

    /*
     * Purpose: recursively determines the shortest path (root to leaf)
     *      inserts a new TreeNode with given value at that leaf
     * Parameters: TreeNode parent - the parent to t
     *             TreeNode t - the current TreeNode in recursive traversal
     *             Integer value - the value to be inserted
     * Returns: nothing
     */
    private void insert(TreeNode parent, TreeNode t, Integer value) {
        if (t==null) {
            if(parent == null)
                root = new TreeNode(value);
            else if(parent.getLeft()==null)
                parent.setLeft(new TreeNode(value));
            else
                parent.setRight(new TreeNode(value));
        }  else {
            int htLeft = height(t.getLeft());
            int htRight = height(t.getRight());
            if (htLeft>htRight)
                insert(t, t.getRight(), value);
            else
                insert(t, t.getLeft(), value);
        }
    }

    /*
     * Purpose: computes and returns the height of BinaryTree t
     *      NOTE a BinaryTree with no node is height 0
     * Parameters: TreeNode t - the BinaryTree
     * Returns: int - the height
     */
    private int height(TreeNode t) {
        if (t == null) {
            return 0;
        }
        if (t.left != null && t.right != null) {
            return Math.max(height(t.left), height(t.right)) + 1;
        } else if (t.left != null) {
            return height(t.left) + 1;
        } else {
            return height(t.right) + 1;
        }
    }


    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode t) {
        if(t == null) {
            return;
        }

        inOrder(t.getLeft());
        System.out.println(t.getValue());
        inOrder(t.getRight());
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(TreeNode t) {
        if(t == null) {
            return;
        }

        System.out.println(t.getValue());
        preOrder(t.getLeft());
        preOrder(t.getRight());
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(TreeNode t) {
        if(t == null) {
            return;
        }

        postOrder(t.getLeft());
        postOrder(t.getRight());
        System.out.println(t.getValue());
    }

    public String toString() {
        String ret = "";
        for (int i=height(root); i>0; i--) {
            ret += toString(root, i) + '\n';
        }
        return ret;
    }

    private String toString(TreeNode t, int level) {
        if (t == null) {
            return "";
        }
        if (height(t) == level) {
            return Integer.toString(t.getValue()) + ' ';
        } else {
            return toString(t.getLeft(), level) + toString(t.getRight(), level);
        }
    }


    // provided for testing of RefBasedBinaryTree class
    public static void main(String[] args) {

        RefBasedBinaryTree myTree = new RefBasedBinaryTree();
        for(int i=2; i<8; i++) {
            myTree.insert(i);
        }
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();

        System.out.println("toString\n" + myTree);
    }

}
