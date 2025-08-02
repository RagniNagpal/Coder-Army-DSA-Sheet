package Arrays;
import java.util.*;
public class union {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int n = a.length + b.length;
        int[] result = new int[n];
        int index = 0;

        // Copy elements of a[]
        for (int i = 0; i < a.length; i++) {
            result[index++] = a[i];
        }

        // Copy elements of b[]
        for (int i = 0; i < b.length; i++) {
            result[index++] = b[i];
        }

        // Sort the combined array
        Arrays.sort(result);

        // Use LinkedHashSet to remove duplicates and maintain order
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : result) {
            set.add(num);
        }

        // Convert Set to ArrayList
        return new ArrayList<>(set);
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        ArrayList<Integer> union = findUnion(arr1, arr2);

        System.out.println("Union of the arrays: " + union);
    }
}
