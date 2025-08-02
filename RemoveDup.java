package Arrays;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDup {

    public ArrayList<Integer> removeDuplicates(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>(); // maintains order

        for (int num : arr) {
            set.add(num);
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        RemoveDup obj = new RemoveDup();
        int[] arr = {4, 5, 4, 2, 2, 3};

        ArrayList<Integer> result = obj.removeDuplicates(arr);
        System.out.println("Array after removing duplicates: " + result);
    }
}
