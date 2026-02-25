package Queue;
import java.util.*;

public class Medium {

    /* -------------------------------
       1823. Find the Winner of the Circular Game
       (Josephus Problem using Queue)
       TC: O(n * k)
       SC: O(n)
    -------------------------------- */
    public static int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        // add players 1 to n
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        // eliminate until one remains
        while (q.size() > 1) {

            // rotate k-1 times
            for (int i = 1; i < k; i++) {
                q.add(q.remove());
            }

            // remove kth player
            q.remove();
        }

        return q.peek(); // winner
    }

    /* -------------------------------
       Reverse a Queue using Stack
       TC: O(n)
       SC: O(n)
    -------------------------------- */
    public static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();

        // queue -> stack
        while (!q.isEmpty()) {
            st.push(q.remove());
        }

        // stack -> queue
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
    }

    /* -------------------------------
       Display Queue safely
    -------------------------------- */
    public static void display(Queue<Integer> q) {
        int n = q.size();
        for (int i = 0; i < n; i++) {
            int x = q.remove();
            System.out.print(x + " ");
            q.add(x);
        }
        System.out.println();
    }


    /* -------------------------------
       Main Method (Testing)
    -------------------------------- */
    public static void main(String[] args) {

        // Reverse Queue Test
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        System.out.print("Original Queue: ");
        display(q);

        reverseQueue(q);

        System.out.print("Reversed Queue: ");
        display(q);

        // Josephus Problem Test
        int winner = findTheWinner(5, 2);
        System.out.println("Winner of Circular Game: " + winner);
    }
}
