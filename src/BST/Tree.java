package BST;
import java.util.*;
public class Tree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    static class Pair{
        Node node;
        Node parent;
        Pair(Node node , Node parent){
            this.node=node;
            this.parent=parent;
        }
    }
    //level order traversal
    public static void levelOrder(Node root){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            System.out.print(curr.data + " ");
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
        }
    }
    //preorder iterative traversal
    public List<Integer> preorder(Node root){
        List<Integer> preorder=new ArrayList<>();
        if(root==null) return preorder;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr=stack.pop();
            preorder.add(curr.data);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return preorder;
    }
    //inorder iterative traversal
    public List<Integer> inorder(Node root){
        List<Integer> inorder=new ArrayList<>();
        if(root==null) return inorder;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(!stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            inorder.add(curr.data);
            curr = curr.right;

        }
        return inorder;
    }
    //level order traversal in spiral form
    public static void spiralLevel(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node curr = s1.pop();
                System.out.print(curr.data);
                if (curr.left != null) s2.push(curr.left);
                if (curr.right != null) s2.push(curr.right);
            }
            while (!s2.isEmpty()) {
                Node curr = s2.pop();
                System.out.print(curr.data + " ");

                // Push children of curr into s1 in R → L order
                if (curr.right != null) s1.push(curr.right);
                if (curr.left != null) s1.push(curr.left);
            }
        }


    }

    //is cousin


    //top view of tree
    //left view of tree;
    //right view of tree
    //bottom view of tree

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);

        System.out.println("Level Order Traversal:");
        levelOrder(root);
        System.out.println();
        spiralLevel(root);
    }
}
