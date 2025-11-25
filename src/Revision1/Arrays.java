package Revision1;
import java.util.*;

public class Arrays {
    public static int[] minmax(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return new int[]{max, min};
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 89, 9, 56};
        int[] result = minmax(arr);
        System.out.println("Max = " + result[0] + ", Min = " + result[1]);
    }
}
