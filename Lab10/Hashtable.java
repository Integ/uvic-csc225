public class Hashtable{

    private static final int TABLE_SZ = 7; // a prime number

    Student[] table;
    int count;  // number of Students in the table

    public Hashtable() {
        table = new Student[TABLE_SZ];
        count = 0;
    }



    /* MethodName: insertCollisions
     * Purpose: insert s into this Hashtable with no collision handling strategy
     * Parameters: Student - s
     * Throws:  TableFullException - if inserting into a full table
     *          CollisionException - if inserting a new key into table at index that is full
     * Returns: nothing
     */
    // TODO: complete this function
    public void insertCollisions(Student s) throws TableFullException, CollisionException {
        int hashcode = s.hashCode();
        int index = hashcode % TABLE_SZ;
        if (table[index] != null) {
            if (table[index].equals(s)) {
                table[index] = s;
            } else if (count >= TABLE_SZ) {
                throw new TableFullException();
            } else {
                throw new CollisionException();
            }
        } else {
            table[index] = s;
            count++;
        }
    }

    /* MethodName: getCollisions
     * Purpose: find Student with sid in this Hashtable with no collision handling and returns their grade
     * Parameters: String - sid
     * Throws:  KeyNotFoundException  - if Student with sid is not found in table
     * Returns: int - the grade of Student with sid
     */
    // TODO: complete this function
    public int getCollisions(String sid) throws KeyNotFoundException {
        int hashcode = sid.hashCode();
        int index = hashcode % TABLE_SZ;
                
        if(table[index].getSID() == sid) {        
            return table[index].getGrade();
        } else {
            throw new KeyNotFoundException();
        }
    }

    /* MethodName: insertLinearProbing
     * Purpose: insert s into this Hashtable with Linear Probing to handle collisions
     * Parameters: Student - s
     * Throws: TableFullException  - if inserting into a full table
     * Returns: nothing
     */
    // TODO: complete this function
    public void insertLinearProbing(Student s) throws TableFullException {
        int hashcode = s.hashCode();
        int index = hashcode % TABLE_SZ;
        if (count >= TABLE_SZ) {
            if (table[index].hashCode() == hashcode) {
                while(table[index].hashCode() == hashcode) {
                    if(table[index].equals(s)) {
                        table[index] = s;
                        break;
                    } else {
                        index++;
                    }
                }
            } else {
                throw new TableFullException();
            }
        } else {
            while (table[index] != null && !table[index].equals(s)) {
                index = (index + 1) % TABLE_SZ;
            }
            if (table[index] == null) {
                count++;
            }
            table[index] = s;
        }
    }

    /* getLinearProbing
     * Purpose: find Student with sid in this Hashtable that uses Linear Probing and returns their grade
     * Parameters: String - sid
     * Throws:  KeyNotFoundException  - if Student with sid is not found in table
     * Returns: int - the grade of Student with sid
     */
    // TODO: complete this function
    public int getLinearProbing(String sid) throws KeyNotFoundException {
        int hashcode = sid.hashCode();
        int index = hashcode % TABLE_SZ;
        if (count >= TABLE_SZ) {
            int start = index;
            while (table[index].getSID() != sid) {
                index = (index + 1) % TABLE_SZ;
                if (index == start) {
                    throw new KeyNotFoundException();
                }
            }
            return table[index].getGrade();
        } else {
            while (table[index] != null && table[index].getSID() != sid) {
                index = (index + 1) % TABLE_SZ;
            }
            if (table[index] != null) {
                return table[index].getGrade();
            } else {
                throw new KeyNotFoundException();
            }
        }
        
    }



    /*
     * Purpose: returns the number of elements in this Hashtable
     * Parameters: none
     * Returns: int - the number of elements
     */
    public int size() {
        return count;
    }

    /*
     * Purpose: returns a String reprensentation of elements
     *      in this Hashtable separated by newlines
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        String s = "";

        for(int i=0; i<TABLE_SZ; i++)
            if (table[i] != null)
                s  += table[i] + "\n";

        return s;
    }


}
