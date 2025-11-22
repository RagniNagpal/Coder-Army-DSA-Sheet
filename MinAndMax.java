package Arrays;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}

public class MinAndMax {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        return new Pair<>(min, max);
    }

    public static void main(String[] args) {
        MinAndMax sol = new MinAndMax();
        int[] arr = {3, 2, 1, 56, 10000, 167};
        Pair<Integer, Integer> result = sol.getMinMax(arr);
        System.out.println("Min: " + result.getKey() + ", Max: " + result.getValue());
    }
}
