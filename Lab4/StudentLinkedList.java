public class StudentLinkedList implements StudentList {
    private StudentNode head;
    private int count;

    public StudentLinkedList() {
        head = null;
        count = 0;
    }

    /*
     * Purpose: adds Student s to back of this list
     * Parameters: Student - s
     * Returns: nothing
     */
    public void add(Student s) {
        StudentNode sn = new StudentNode(s);
        StudentNode cur = head;

        if (count == 0) {
            head = sn;
        } else {
            while (cur != null) {
                if (cur.getNext() == null) {
                    cur.setNext(sn);
                    cur = sn;
                }
                cur = cur.getNext();
            }
        }

        count = count + 1;
    }

    /*
     * Purpose: returns the number of elements in this list
     * Parameters: none
     * Returns: int - the number of elements
     */
    public int size() {
        return count;
    }
    
    /*
     * Purpose: returns a String reprensentation of the elements
     *      in this list separated by newlines
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        String result = "";
        StudentNode cur = head;

        while (cur != null) {
            result += cur.getData() + "\n";
            cur = cur.getNext();
        }
        return result;
    }
    
    /*
     * Purpose: removes the first element in the list
     * Parameters: none
     * Returns: nothing
     */
    public void removeFront() {
        head = head.getNext();
        count = count - 1;
    }
    
    /*
     * Purpose: determines whether a Student which is equivalent to s
     *      is contained in this list
     * Parameters: Student - s
     * Returns: boolean - true if a Student matching s is found,
     *  false otherwise
     */
    public boolean contains(Student s) {
        boolean res = false;
        StudentNode cur = head;
        while(cur != null) {
            if (cur.getData().equals(s)) {
                res = true;
            }
            cur = head.getNext();
        }
        return res;
    }
}