package BST;

class Node{
    int val;
    Node left, right;
    Node(int data){
        val=data;
    }
}
public class BST {
    //bst  search
    public static Node search(Node root, int value) {
        if (root == null || root.val == value) return root;

        if (value < root.val)
            return search(root.left, value);
        else
            return search(root.right, value);
    }

    //Array To BST
    public static Node sortedArrayToBst(int[] nums){
        if(nums==null || nums.length==0) return null;
        return buildBST(nums,0,nums.length-1);
    }
    public static  Node buildBST(int[] nums,int left,int right){
        if(left > right) return null;
        int mid=left + (right-left)/2;
        Node node=new Node(nums[mid]);

        node.left=buildBST(nums,left,mid-1);
        node.right=buildBST(nums,mid+1,right);

        return node;
    }
    //Insert in bst
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);

        return root;
    }

    //inorder
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }
    //bst from preorder
    public static Node preorderBST(int[] preorder){
        Node root=null;
        for(int i=0;i<preorder.length;i++){
            root = pre(root, preorder[i]);
        }
        return root;
    }
    public static Node pre(Node root,int val){
        if(root==null) return new Node(val);
        if (val < root.val)
            root.left = pre(root.left, val);
        else if (val > root.val)
            root.right = pre(root.right, val);

        return root;
    }
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Node root = sortedArrayToBst(nums); // Build the BST
        System.out.println("Inorder Traversal of BST: ");
        inorder(root);
        root = insert(root, 7);

        System.out.println("Inorder Traversal of BST after insertion: ");
        inorder(root);
        root = preorderBST(nums);

        System.out.println("Inorder Traversal of BST after insertion: ");
        inorder(root);
    }
}
