package LinkedList;

import java.sql.SQLOutput;

// 🔹 Node class
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

// 🔹 LinkedList class
class LinkedList {
    Node head;   // initially null
    Node tail;   // initially null
    int size;

//    LinkedList() {
//        head = null;
//        tail = null;
//
//    }
    void addAtTail(int val){
        Node temp=new Node(val);
        if(tail==null){
            head=tail=temp;
        }
        else{
            tail.next=temp;
            tail=temp;
        }
        size++;
    }
    int search(int val){
        if(head==null) return -1;
        Node temp=head;
        int idx=0;
        while(temp!=null){
            if(temp.val==val) return idx;
            temp=temp.next;
            idx++;
        }
        return -1;
    }
    void delete(int idx){
        if(idx < 0 || idx>=size){
            System.out.println("Invalid index");
            return;

        }
        if(idx==0){
            deleteAtHead();
            return;
        }
        Node temp=head;
        for(int i=1;i<=idx-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        if(idx==size-1) tail=temp;
        size--;
    }
    void insert(int idx,int val){

    }
    void addAtHead(int val){
        Node temp=new Node(val);
        if(head==null){
            head=tail=temp;
        }
        else{
            temp.next=head;
            head=temp;
        }
        size++;
    }
    void deleteAtHead(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        head=head.next;
        if(head==null) tail=null;  //tail head se pahele nhi ho sakti
        size--;
    }
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val + " ");
            temp=temp.next;
        }
        System.out.println();
    }
}

// 🔹 Main public class
public class SinglyLL {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // here you can perform insertions, etc.
        System.out.println("Linked List object created successfully!");
        ll.addAtTail(10);
        ll.display();
        ll.addAtTail(10);
        ll.display();
        ll.addAtTail(30);
        ll.addAtHead(40);
        ll.addAtHead(50);
        ll.deleteAtHead();
        ll.display();
        System.out.println(ll.size);
        System.out.println("Index of 30: " + ll.search(30));
        System.out.println("Index of 100: " + ll.search(100)); // not found → -1

    }
}
