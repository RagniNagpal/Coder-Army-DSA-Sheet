package HashMap;
import java.util.*;

public class Increment {

    public static List<Integer> finalStream(int[] A) {
        List<Integer> stream = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : A) {
            if (!map.containsKey(num)) {
                map.put(num, stream.size());
                stream.add(num);
            } else {
                int index = map.get(num);
                int incremented = stream.get(index) + 1;
                stream.set(index, incremented); // update the old value
                stream.add(num);                // add the number again
                map.put(num, stream.size() - 1); // update index in map to the latest one
            }
        }

        return stream;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 1};
        int[] A2 = {1, 2};
        int[] A3 = {1, 1, 2, 2};

        System.out.println("Output 1: " + finalStream(A1)); // [2, 1]
        System.out.println("Output 2: " + finalStream(A2)); // [1, 2]
        System.out.println("Output 3: " + finalStream(A3)); // [3, 1, 3, 2]
    }
}
