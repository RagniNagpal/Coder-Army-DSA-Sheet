package Arrays;

import java.util.*;

public class AlterPosNeg {

    public static void rearrange(ArrayList<Integer> arr) {
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();

        for (int val : arr) {
            if (val >= 0) pos.offer(val);
            else neg.offer(val);
        }

        arr.clear();

        while (!pos.isEmpty() || !neg.isEmpty()) {
            if (!pos.isEmpty()) arr.add(pos.poll());
            if (!neg.isEmpty()) arr.add(neg.poll());
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(9, 4, -2, -1, 5, 0, -5, -3, 2));
        rearrange(arr);
        System.out.println(arr);
    }
}
