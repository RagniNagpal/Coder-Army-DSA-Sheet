package Queue;

public class QueueArray {

    private int[] arr;
    private int front, rear, size, capacity;

    // Constructor
    public QueueArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // enqueue (add)
    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity; // circular
        arr[rear] = val;
        size++;
    }

    // dequeue (remove)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int removed = arr[front];
        front = (front + 1) % capacity; // circular
        size--;
        return removed;
    }

    // peek (front element)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    // isFull
    public boolean isFull() {
        return size == capacity;
    }

    // size
    public int size() {
        return size;
    }

    // display
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    // ----------------------------
    // main method for testing
    // ----------------------------
    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // Queue: 10 20 30

        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Front: " + q.peek());       // 20

        q.enqueue(40);
        q.enqueue(50);
        q.display(); // Queue: 20 30 40 50

        q.enqueue(60); // Queue Overflow
        System.out.println("Size: " + q.size());

        q.dequeue();
        q.enqueue(60);
        q.display(); // Queue: 30 40 50 60
    }
}


//        | Operation | Complexity  | Notes                                    |
//        | --------- | ----------- | ---------------------------------------- |
//        | `enqueue` | O(1)        | Circular index `(rear+1)%capacity`       |
//        | `dequeue` | O(1)        | Circular index `(front+1)%capacity`      |
//        | `peek`    | O(1)        | Front element                            |
//        | `isEmpty` | O(1)        | Size variable                            |
//        | `isFull`  | O(1)        | Size variable                            |
//        | `size`    | O(1)        | Size variable                            |
//        | `display` | O(n)        | Traverse size elements                   |
//        | **Space** | O(capacity) | Fixed size array, no extra node pointers |
