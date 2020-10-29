public class StackArrayBased implements Stack {
    private static final int INIT_SZ = 4;
    private char[] data;
    private int top;
    // NOTICE:  there is no count
    //  think about why you do not need a count given
    //  you are keeping track of the index of top
    

    public StackArrayBased() {
        data = new char[INIT_SZ];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(char val) {
        top = top + 1;
        if (top >= data.length) {
            char[] newData = new char[data.length + 1];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[top] = val;
    }


    public char pop() {
        try {
            char ret = data[top];
            top = top - 1;
            return ret;
        } catch (Exception e) {
            System.out.println("Stack is Empty Can Not Pop.");
            return '\0';
        }
    }

    public char peek() {
        try {
            return data[top];
        } catch (Exception e) {
            System.out.println("Stack is Empty Can Not Peek.");
            return '\0';
        }
    }


    public void popAll() {
        top = -1;
    }

    public String toString() {
        String result = "{";
        for (int i = 0; i <= top; i++) {
            result += data[i];
        }
        result += "}";
        return result;
    }
}