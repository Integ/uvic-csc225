public class A4Stack<T> implements Stack<T> {
	
	private static final int DEFAULT_CAPACITY = 5;
	private T[] data;
	private int top;

	public A4Stack() {
		data = (T[]) new Object[DEFAULT_CAPACITY];
		top = 0;
	}
	
	public A4Stack(int size) {
		data = (T[]) new Object[size];
		top = 0;
	}
	
	public void push(T v) {
		// TODO: implement this
		if (top >= data.length) {
	      	throw new FullStackException("Stack is Full Can Not Push.");
    	} else {
      		data[top] = v;
			top = top + 1;
    	}
	}
	
	public T pop() {
		// TODO: implement this	
		if (top == 0) {
			throw new EmptyStackException("Stack is Empty Can Not Pop.");
		} else {
			T ret = data[top - 1];
			top = top - 1;
			return ret;
		}
	}
	
	public void popAll() {
		// TODO: implement this	
		top = 0;
	}
	
	public boolean isEmpty() {
		// TODO: implement this	
		if (top == 0) {
            return true;
        } else {
            return false;
        }
	}
	
	public boolean isFull() {
		// TODO: implement this	
		if (top >= data.length) {
            return true;
        } else {
            return false;
        }
	}
	
	public T top() {
		// TODO: implement this	
		if (top == 0) {
			throw new EmptyStackException("Stack is Empty Can Not Top.");
		} else {
			T ret = data[top - 1];
			return ret;
		}
	}
}