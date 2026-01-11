package BST;

public class Basics {

    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }



    // Insert method
    static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        }
        // duplicates ignored
        return root;
    }

    // Inorder traversal
    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Search in BST
    static Node search(Node root, int val) {
        if (root == null || root.data == val) {
            return root;
        }

        if (val < root.data) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    //delete(leaf)
    static Node deleteLeaf(Node root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = deleteLeaf(root.left, key);
        } else if (key > root.data) {
            root.right = deleteLeaf(root.right, key);
        } else {
            // key found
            if (root.left == null && root.right == null) {
                return null; // delete leaf
            }
        }
        return root;
    }
    //min distanmce bw
    //delete(val)
    //delete( 1 child)

    //valid bst
    public static boolean validBST(Node root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean isValid(Node root, long min, long max) {
        if (root == null) return true; // ✅ empty tree is valid

        // ✅ Check BST property
        if (root.data <= min || root.data >= max) return false;

        // ✅ Check both subtrees
        return isValid(root.left, min, root.data) &&
                isValid(root.right, root.data, max);
    }

    //min distance bw bst
//    public static minDist(Node root){
//
//    }
    // Main function — how the tree is created
    public static void main(String[] args) {
        int arr[] = {50, 30, 70, 20, 40, 60, 80};
        Node root = null;

        for (int val : arr) {
            root = insert(root, val);
        }

        System.out.println("Inorder traversal of BST:");
        inorder(root);

        int key = 80; // leaf node
        Node result = search(root, key);
        if (result != null)
            System.out.println("\nElement " + key + " found in BST.");
        else
            System.out.println("\nElement " + key + " not found in BST.");

        root = deleteLeaf(root, key);
        System.out.println("\nAfter deleting leaf " + key + ":");
        inorder(root);
        System.out.println();
        System.out.println(validBST(root));
    }
}

