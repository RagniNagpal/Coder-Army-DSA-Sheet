//package BST;
//
//public class Inputs {
//}
//import java.util.*;
//
//public class CreateTreeRecursive {
//    static Scanner sc = new Scanner(System.in);
//
//    // Node class
//    static class Node {
//        int data;
//        Node left, right;
//        Node(int data) {
//            this.data = data;
//        }
//    }
//
//    // Recursive function to create tree
//    static Node createTree() {
//        System.out.print("Enter node value: ");
//        int val = sc.nextInt();
//        Node nn = new Node(val);
//
//        System.out.print("Do you have left child of " + val + "? (true/false): ");
//        boolean hasLeft = sc.nextBoolean();
//        if (hasLeft) {
//            nn.left = createTree(); // recursive call for left child
//        }
//
//        System.out.print("Do you have right child of " + val + "? (true/false): ");
//        boolean hasRight = sc.nextBoolean();
//        if (hasRight) {
//            nn.right = createTree(); // recursive call for right child
//        }
//
//        return nn;
//    }
//
//    // Inorder Traversal
//    static void inorder(Node root) {
//        if (root == null) return;
//        inorder(root.left);
//        System.out.print(root.data + " ");
//        inorder(root.right);
//    }
//
//    public static void main(String[] args) {
//        Node root = createTree();
//        System.out.println("\nInorder Traversal:");
//        inorder(root);
//    }
//}



//level order mei inputs
//10 20 30 40 50 -1 60 -1 -1 -1 -1 70 -1 -1 -1

//package BST;
//import java.util.*;
//
//public class LevelOrderTree {
//
//    static class Node {
//        int data;
//        Node left, right;
//        Node(int val) { data = val; }
//    }
//
//    // Build tree from level order input
//    static Node buildTreeLevelOrder() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter level order data (-1 for null):");
//        int val = sc.nextInt();
//        if (val == -1) return null;
//
//        Node root = new Node(val);
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//
//        while (!q.isEmpty()) {
//            Node curr = q.poll();
//
//            int leftVal = sc.nextInt();
//            if (leftVal != -1) {
//                curr.left = new Node(leftVal);
//                q.add(curr.left);
//            }
//
//            int rightVal = sc.nextInt();
//            if (rightVal != -1) {
//                curr.right = new Node(rightVal);
//                q.add(curr.right);
//            }
//        }
//        return root;
//    }
//
//    // Level order traversal to verify tree
//    static void levelOrder(Node root) {
//        if (root == null) return;
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//
//        while (!q.isEmpty()) {
//            Node curr = q.poll();
//            System.out.print(curr.data + " ");
//            if (curr.left != null) q.add(curr.left);
//            if (curr.right != null) q.add(curr.right);
//        }
//    }
//
//    public static void main(String[] args) {
//        Node root = buildTreeLevelOrder();
//
//        System.out.println("\nLevel Order Traversal of Constructed Tree:");
//        levelOrder(root);
//    }
//}

//
//public static Node buildTree(){
//    int val=sc.nextInt();
//    if(val==-1) return null;
//    Node root=new Node(val);
//    Queue<Node> q=new LinkedList<>();
//    q.add(root);
//    while(!q.isEmpty()){
//        Node curr=q.poll();
//        int left=sc.nextInt();
//        if(left!=-1){
//            curr.left=new Node(left);
//            q.add(curr.left);
//        }
//        int right= sc.nextInt();
//        if(right!=-1){
//            curr.right=new Node(right);
//            q.add(curr.right);
//        }
//    }
//    return root;
//}

//package com.G26child2.Trees;
//
//import java.util.Scanner;
//
//public class Input {
//  static   Scanner sc = new Scanner(System.in);
//    public static class  Node{
//        int data;
//        Node left;
//        Node right;
//        Node(int data){
//            this.data = data;
//        }
//    }
//    public  static  Node buildTree(){
//
//        int value=sc.nextInt();
//        Node root=new Node(value);
//        boolean left=sc.nextBoolean();
//        if(left){
//            root.left=buildTree();
//        }
//        boolean right=sc.nextBoolean();
//        if(right){
//            root.right=buildTree();
//        }
//        return root;
//    }
//    public  static  void display(Node root){
//        if(root==null){
//            return;
//        }
//        System.out.println(root.data);
//        display(root.left);
//        display(root.right);
//    }
//    public static void main(String[] args) {
//        Node root= buildTree();
//        display(root);
//    }
//}

//package com.G26child2.Trees;
//
//import java.util.Scanner;
//
//public class input1 {
//    static Scanner sc = new Scanner(System.in);
//    public static class  Node{
//        int data;
//        Node left;
//        Node right;
//        Node(int data){
//            this.data = data;
//        }
//    }
//    public  static Node Tree(){
//        int input=sc.nextInt();
//        if(input==-1)return null;
//        Node root=new Node(input);
//        root.left=Tree();
//        root.right=Tree();
//        return root;
//    }
//    public  static  void display(Node root){
//        if(root==null)return;
//        System.out.print(root.data+" ");
//        display(root.left);
//        display(root.right);
//    }
//    public static void main(String[] args) {
//        Node root= Tree();
//        display(root);
//    }
//}