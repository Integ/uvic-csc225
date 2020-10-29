public class ShapeList{
    
    private static final int INIT_SZ = 2;
    
    Shape[] elements;
    int count;
    
    public ShapeList() {
        
        
    }
    
    /*
     * Purpose: returns the number of elements in list
     * Parameters: none
     * Returns: int - the number of elements
     */
    public int size() {
        // ToDo
        return count;
    }
    
    /*
     * Purpose: adds Shape s to back of this list
     * Parameters: Shape - s
     * Returns: nothing
     */
    public void add(Shape s) {
        // ToDo
        if (count == 0) {
            elements = new Shape[INIT_SZ];
        }

        if (count >= INIT_SZ) {
            Shape[] newElements = new Shape[count + 1];
            for (int i = 0; i < count; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }

        elements[count] = s;
        count++;
    }
    
    /*
     * Purpose: returns a String reprensentation of the elements
     *      in this list separated by newlines
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        // ToDo
        String ret = "";
        for (int i = 0; i < count; i++) {
            ret += elements[i].toString() + "\n";
        }
        return ret;
    }
    
    /*
     * Purpose: removes the first element in this list
     * Parameters: none
     * Returns: nothing
     */
    public void removeFront() {
        // ToDo
        Shape[] newElements; 
        if (count == 0) {
            newElements = new Shape[INIT_SZ];
        } else {
            newElements = new Shape[count - 1];
        }
        
        for (int i = 0; i < elements.length; i++) {
            if(i >= 1) {
                newElements[i - 1] = elements[i];
            }
        }
        elements = newElements;
    }
    
    
}
