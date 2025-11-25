package LinkedList;

// 🔹 ListNode class (for LeetCode-style problems)
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class Leetcode {

    // ======================================================
    // 🔸 1️⃣ Delete a given node (LeetCode-style)
    // ======================================================
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // ======================================================
    // 🔸 2️⃣ Find middle node using fast & slow pointer
    // ======================================================
    public ListNode middleNodeFastSlow(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // ======================================================
    // 🔸 3️⃣ Find middle node using length method
    // ======================================================
    public int getMiddle(Node head) {
        if (head == null) return -1;

        int length = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        temp = head;
        for (int i = 1; i <= length / 2; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    // ======================================================
    // 🔸 4️⃣ Display LinkedList (for custom Node)
    // ======================================================
    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ======================================================
    // 🔸 5️⃣ Display LinkedList (for ListNode)
    // ======================================================
    public void displayListNode(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //kth from last
    public int getKthFromLast(Node head, int k){
        Node slow=head;
        Node fast=head;
        for(int i=1;i<=k;i++){
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow.val;
    }

    //detect a loop
    public int detectLoop(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return 1;
            }
        }
        return 0;
    }

    //Length of Loop in LL
    public int lengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Loop detected, calculate its length
                int len = 1;
                ListNode temp = slow.next;
                while (temp != slow) {
                    len++;
                    temp = temp.next;
                }
                return len;
            }
        }

        // No loop
        return 0;
    }


    //find the starting point of ll
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode temp = head;
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }


        return null;
    }

    //palindrome list
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half (iteratively)
        ListNode secondHalf = reverseList(slow);

        // Step 3: Compare both halves
        ListNode firstHalf = head;
        ListNode temp = secondHalf;
        while (temp != null) {
            if (firstHalf.val != temp.val)
                return false;
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        // Step 4 (Optional): Restore list
        // reverseList(secondHalf);

        return true;
    }

    // Iterative reverse
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }


    // ======================================================
    // 🔸 MAIN FUNCTION TO TEST EVERYTHING
    // ======================================================
    public static void main(String[] args) {
        Leetcode obj = new Leetcode();

        // 🧩 Test 1: Delete Node (LeetCode)
        System.out.println("=== Delete Node Demo ===");
        ListNode a = new ListNode(4);
        a.next = new ListNode(5);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(9);

        System.out.print("Original List: ");
        obj.displayListNode(a);

        // Suppose we want to delete node with value 5
        obj.deleteNode(a.next);  // delete node "5"

        System.out.print("After Deletion: ");
        obj.displayListNode(a);

        // 🧩 Test 2: Middle Node (fast & slow)
        System.out.println("\n=== Middle Node (Fast & Slow) ===");
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        ListNode midNode = obj.middleNodeFastSlow(head);
        System.out.println("Middle node value: " + midNode.val);

        // 🧩 Test 3: Middle Node (length method)
        System.out.println("\n=== Middle Node (Length Method) ===");
        Node n1 = new Node(11);
        n1.next = new Node(22);
        n1.next.next = new Node(33);
        n1.next.next.next = new Node(44);
        n1.next.next.next.next = new Node(55);

        System.out.print("List: ");
        obj.display(n1);
        int middle = obj.getMiddle(n1);
        System.out.println("Middle element: " + middle);
    }
}


