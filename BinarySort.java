package Arrays;

public class BinarySort {
    public void binSort(int[] arr) {
        int zeroCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                zeroCount++;
        }

        for (int i = 0; i < zeroCount; i++)
            arr[i] = 0;
        for (int i = zeroCount; i < arr.length; i++)
            arr[i] = 1;
    }

    public static void main(String[] args) {

    }
}
