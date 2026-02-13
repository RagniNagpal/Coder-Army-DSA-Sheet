
package Queue;
import java.util.*;

// File name: QueueLL.java
public class QueueLL {

    // Node class (inner class)
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Queue LinkedList Implementation
    private Node front, rear;
    private int size;

    // Constructor
    public QueueLL() {
        front = rear = null;
        size = 0;
    }

    // enqueue (add)
    public void enqueue(int val) {
        Node newNode = new Node(val);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // dequeue (remove)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int removed = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return removed;
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return front.data;
    }

    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    // size
    public int size() {
        return size;
    }

    // display
    public void display() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ----------------------------
    // main method for testing
    // ----------------------------
    public static void main(String[] args) {
        QueueLL q = new QueueLL();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();  // 10 20 30

        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Front: " + q.peek());       // 20

        q.enqueue(40);
        q.display();  // 20 30 40

        System.out.println("Size: " + q.size());
    }
}


//            | Operation | TC   | SC   |
//            | --------- | ---- | ---- |
//            | enqueue   | O(1) | O(1) |
//            | dequeue   | O(1) | O(1) |
//            | peek      | O(1) | O(1) |
//            | display   | O(n) | O(1) |
//            | overall   | —    | O(n) |
