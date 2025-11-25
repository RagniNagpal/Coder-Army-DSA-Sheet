package LinkedList;

import java.sql.SQLOutput;

public class Basic {

    // ✅ Make Node static so it can be used in static methods
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // ✅ Display function to print linked list
    public static void display(Node head) {
//        Node temp = head;
//        while (temp != null) {
//            System.out.print(temp.data + " -> ");
//            temp = temp.next;
//        }
//        System.out.println("NULL");

        //or

        for(Node temp=head;temp!=null;temp=temp.next){
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    public static void displayRec(Node head){
        if(head==null){
            return;
        }
        System.out.print(head.data + "->");
        displayRec(head.next);
    }
    public static int get(Node head, int idx){
        Node temp=head;   //imp
        for(int i=1;i<=idx;i++){
            temp=temp.next;
        }
        return temp.data;
    }
    public static void main(String[] args) {

        // 🔹 Step 1: Create separate node objects
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);

        // 🔹 Step 2: Link them manually using .next
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        // 🔹 Step 3: Head points to first node
        Node head = a;

        // 🔹 Step 4: Display Linked List
//        display(head);
//        displayRec(head);
        System.out.println(get(head,3));
    }
}
