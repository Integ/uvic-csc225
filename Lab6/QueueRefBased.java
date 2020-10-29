public class QueueRefBased<T> implements Queue<T> {
    
    private QueueNode<T> front;
    private QueueNode<T> back;
    
    public QueueRefBased() {
        front = null;
        back = null;
    }
    
    public int size() {
        int count = 0;
        // TODO: complete
        QueueNode qn = front;
        while (qn != null) {
            count++;
            qn = qn.next;
        }
        return count;
    }


    public boolean isEmpty() {
        // TODO: complete
        return front == null && back == null;
    }


    public void enqueue (T element) {
        // TODO: complete
        QueueNode newBack = new QueueNode<T>(element);
        if (back != null) {
            back.setNext(newBack);
        } else {
            front = newBack;
            back = newBack;
        }
        back = newBack;
    }

    public T dequeue() {
        // TODO: complete
        try {
            T ret = front.data;
            front = front.next;
            if (front == null) {
                back = null;
            }
            return ret;
        } catch (Exception e) {
            System.out.println("Queue is Empty Can Not Dequeue.");
            return null;
        }
    }

    public T peek() {
        // TODO: complete
        return front.data;
    }

    public void makeEmpty() {
        // TODO: complete
        front = null;
        back = null;
    }
}