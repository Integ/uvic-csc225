/*
 * ArrayBasedBinaryTree.java
 *
 * An array-based BinaryTree meant to store values of type Integer
 */
public class ArrayBasedBinaryTree {
    private static final int CAPACITY = 100;
    protected Integer[] data;
    protected int root;
    protected int size;

    public ArrayBasedBinaryTree() {
        this.data = new Integer[CAPACITY];
        this.root = 0;
        this.size = 0;
    }

    /*
     * Purpose: inserts the given value into data at next available
     *  position in a level-order traversal
     *  The tree remains complete after insertion.
     * Parameters: Integer value - value to insert
     * Returns: nothing
     */
    public void insert(Integer value) {
        this.data[size] = value;
        this.size += 1;
    }


    /*
     * Purpose: calculates and returns the index of t's left child
     * Parameters: int t - index of current element in this ArrayBasedBinaryTree
     * Returns: int - index of left child
     */
    protected int getLeft(int t) {
        return 2*t+1;
    }

    /*
     * Purpose: calculates and returns the index of t's right child
     * Parameters: int t - index of current element in this ArrayBasedBinaryTree
     * Returns: int - index of right child
     */
    protected int getRight(int t) {
        return 2*t+2;
    }


    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(int t) {
        if (data[t] == null) {
            return;
        }

        inOrder(getLeft(t));
        System.out.println(data[t]);
        inOrder(getRight(t));
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(int t) {
        if (data[t] == null) {
            return;
        }

        System.out.println(data[t]);
        preOrder(getLeft(t));
        preOrder(getRight(t));
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(int t) {
        if (data[t] == null) {
            return;
        }

        postOrder(getLeft(t));
        postOrder(getRight(t));
        System.out.println(data[t]);
    }

    public String toString() {
        String ret = "";
        int level = 0;
        int count = 0;
        for (int i=0; i<size; i++) {
            ret += data[i];
            if (count + Math.pow(2, level) - 1 == i) {
                ret += '\n';
                count += Math.pow(2, level);
                level += 1;
            } else {
                if(i%2==1) {
                    ret += '^';
                } else {
                    ret += ' ';
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        ArrayBasedBinaryTree myTree = new ArrayBasedBinaryTree();
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
