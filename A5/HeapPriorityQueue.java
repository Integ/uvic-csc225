/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/

public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;

	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		storage = new Comparable[DEFAULT_SIZE];
		currentSize = 0;
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		storage = new Comparable[size];
		currentSize = 0;
	}

	public void insert ( Comparable element ) {
	    if (currentSize == storage.length) {
        	throw new HeapFullException();
    	}

		if (currentSize == 0) {
			storage[currentSize++] = element;
			return;
		}

		int curIndex = currentSize;
		int parentIndex;
		if (curIndex % 2 == 0) {
			parentIndex = (curIndex-2)/2;
		} else {
			parentIndex = (curIndex-1)/2;
		}
	    while (parentIndex >= 0 && storage[parentIndex].compareTo(element) > 0) {
        	storage[curIndex] = storage[parentIndex];
			curIndex = parentIndex;
			if (curIndex % 2 == 0) {
				parentIndex = (curIndex-2)/2;
			} else {
				parentIndex = (curIndex-1)/2;
			}
		}

    	storage[curIndex] = element;
		currentSize++;
	}
	
	public Comparable removeMin() {
		if (currentSize == 0) {
			throw new HeapEmptyException();
		}

		Comparable root = storage[0];
        int curIndex = 0;
        int leftChildIndex = 2 * curIndex + 1;
		int rightChildIndex = leftChildIndex + 1;
		int minChildIndex;
        while(currentSize > rightChildIndex){
            if((rightChildIndex < currentSize-1)  && storage[leftChildIndex].compareTo(storage[rightChildIndex]) > 0) {
                minChildIndex = rightChildIndex;
            } else {
				minChildIndex = leftChildIndex;
			}
            if(storage[minChildIndex].compareTo(storage[currentSize-1]) < 0){
                storage[curIndex] = storage[minChildIndex];
                curIndex = minChildIndex;
				leftChildIndex = 2 * curIndex + 1;
				rightChildIndex = leftChildIndex + 1;
            } else {
                break;
            }
        }
        storage[curIndex] = storage[currentSize - 1];
        currentSize--;
        return root;
	}
	
	public boolean isEmpty(){
		//TODO: Implement this
		return currentSize == 0;
	}
	
	public int size () {
		//TODO: Implement this
		return currentSize; // so it compiles
	}

	public String toString() {
		String s = "";
		String sep = "";
		for(int i=0;i<currentSize;i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}

}
