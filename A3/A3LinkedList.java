// Name:
// Student number: v00

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
        A3Node newHead = new A3Node(s);
        newHead.setNext(head);
        if (head != null) {
            head.setPrev(newHead);
        }
        if (tail == null) {
            tail = newHead;
        }
        head = newHead;
        length = length + 1;
	}

	public void addBack(String s) {
        A3Node newTail = new A3Node(s);
        newTail.setPrev(tail);
        if (head == null) {
            head = newTail;
        }
        if (tail != null) {
            tail.setNext(newTail);
        }
		tail = newTail;
        length = length + 1;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
        head = head.next;
        if (head != null) {
            head.setPrev(null);
        }
        length = length - 1;
        if (length == 0) {
            tail = null;
        }
	}
	
	public void removeBack() {
        tail = tail.prev;
        if (tail != null) {
            tail.setNext(null);
        }
        length = length - 1;
        if (length == 0) {
            head = null;
        }
	}
	
	
	public void rotate(int n) {
        if (length != 0) {
            for (int i = 0; i < n; i++) {
                this.addFront(tail.getData());
                this.removeBack();
            }
        }
	}
	
	public void interleave(A3LinkedList other) {
        A3Node cur1 = head;
        A3Node cur2 = other.head;
		for (int i=0; i<length; i++) {
            if(cur1 != null && cur2 != null) {
                A3Node tmpNext = cur1.getNext();
                cur1.setNext(cur2.getNext());
                cur2.setNext(tmpNext);
				
                A3Node tmpPrev = cur1.getPrev();
                cur1.setPrev(cur2.getPrev());
                cur2.setPrev(tmpPrev);

				tail = cur1;
				other.tail = cur2;
				
                cur1 = cur1.getNext();
                cur2 = cur2.getNext();
            }
        }
	}
	
	/* Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/* Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}