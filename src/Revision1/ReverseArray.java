package Revision1;
import java.util.Arrays;

public class ReverseArray {
    public void reverse(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ReverseArray obj = new ReverseArray();
        obj.reverse(arr);
        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }
}
