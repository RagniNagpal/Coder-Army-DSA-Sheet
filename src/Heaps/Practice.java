package Heaps;
import java.util.*;

public class Practice {
    // Magician and Chocolates
    public static int MandC(int n, int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long count = 0;
        int MOD = 1_000_000_007;

        for(int i : arr){
            pq.add(i);
        }

        for(int i = 0; i < n; i++){
            int eaten = pq.poll();
            count = (count + eaten) % MOD; // add eaten chocolates
            pq.add(eaten / 2);            // magician refills the bag
    }

        return (int) count;
    }

    public static void main(String[] args) {
        int A = 3;
        int[] B = {6, 5};
        System.out.println(MandC(A, B)); // expected output: 14
    }
}
