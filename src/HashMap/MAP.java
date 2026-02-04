package HashMap;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.Arrays;

public class MAP {
    public static void main(String[] args) {
        HashMap<Integer,String> map1=new HashMap<>();

        map1.put(1,"R");
        map1.put(2,"S");
        map1.put(3,"T");

        //1 null allowed
//        map.put(null,"v");
//        map.put(null,"Ti");  //v replaced by Ti
        System.out.println(map1);

        String student=map1.get(2);
        System.out.println(student);
        String student2=map1.get(21);
        System.out.println(student);

        System.out.println(map1.containsKey(2));
        System.out.println(map1.containsValue("S"));

        Set<Integer> keys=map1.keySet();
        for(int i :keys){
            System.out.println(map1.get(i));
        }
        for(int i : map1.keySet()){
            System.out.println(map1.get(i));
        }

        Set<Map.Entry<Integer,String>> entries=map1.entrySet();

        for(Map.Entry<Integer,String> entry : entries){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        for(Map.Entry<Integer,String> entry : entries){
            entry.setValue(entry.getValue().toLowerCase());
        }
        System.out.println(map1);

        map1.remove(3);
        boolean res=map1.remove(2,"N");
        System.out.println("Removed" + res);
        System.out.println(map1);

        List<Integer> list=Arrays.asList(2,4,32,43,4,432);
        list.contains(32);

        //hashmap ke anadar data buckets(array) mei store hot hai
        //hash function: converts a key into an index for storage

                // 1️⃣ Create HashMap
                HashMap<Integer, String> map = new HashMap<>();

                // 2️⃣ put() – insert / update
                map.put(1, "Apple");
                map.put(2, "Banana");
                map.put(3, "Cherry");

                // null key & null value
                map.put(null, "NullKey");
                map.put(4, null);

                System.out.println("Initial Map: " + map);

                // 3️⃣ get()
                System.out.println("get(2): " + map.get(2));     // Banana
                System.out.println("get(10): " + map.get(10));   // null

                // 4️⃣ containsKey()
                System.out.println("containsKey(3): " + map.containsKey(3));

                // 5️⃣ containsValue()
                System.out.println("containsValue(\"Apple\"): " + map.containsValue("Apple"));

                // 6️⃣ size()
                System.out.println("Size: " + map.size());

                // 7️⃣ isEmpty()
                System.out.println("isEmpty: " + map.isEmpty());

                // 8️⃣ keySet()
                System.out.println("Keys:");
                for (Integer key : map.keySet()) {
                    System.out.println(key);
                }

                // 9️⃣ values()
                System.out.println("Values:");
                for (String value : map.values()) {
                    System.out.println(value);
                }

                // 🔟 entrySet()
                System.out.println("Entries:");
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                }

                // 1️⃣1️⃣ remove()
                map.remove(3);
                System.out.println("After remove(3): " + map);

                // 1️⃣2️⃣ remove(key, value)
                map.remove(2, "Banana");
                System.out.println("After remove(2, Banana): " + map);

                // 1️⃣3️⃣ replace()
                map.replace(1, "APPLE");
                System.out.println("After replace(1): " + map);

                // 1️⃣4️⃣ replace(key, oldVal, newVal)
                map.replace(1, "APPLE", "AppleNew");
                System.out.println("After conditional replace: " + map);

                // 1️⃣5️⃣ putIfAbsent()
                map.putIfAbsent(5, "Mango");
                System.out.println("After putIfAbsent: " + map);

                // 1️⃣6️⃣ getOrDefault()
                System.out.println("getOrDefault(100): " +
                        map.getOrDefault(100, "Not Found"));

                // 1️⃣7️⃣ compute()
                map.compute(1, (k, v) -> v + "_Updated");
                System.out.println("After compute: " + map);

                // 1️⃣8️⃣ computeIfAbsent()
                map.computeIfAbsent(6, k -> "Orange");
                System.out.println("After computeIfAbsent: " + map);

                // 1️⃣9️⃣ computeIfPresent()
                map.computeIfPresent(5, (k, v) -> v.toUpperCase());
                System.out.println("After computeIfPresent: " + map);

                // 2️⃣0️⃣ forEach()
                System.out.println("Using forEach:");
                map.forEach((k, v) -> System.out.println(k + " -> " + v));

                // 2️⃣1️⃣ clear()
                map.clear();
                System.out.println("After clear(): " + map);

                //Basic frequency count

//        HashMap<Integer, Integer> freq = new HashMap<>();
//
//        for (int x : arr) {
//            freq.put(x, freq.getOrDefault(x, 0) + 1);
//        }
//
//        HashMap<Character, Integer> freq = new HashMap<>();
//
//        for (char ch : s.toCharArray()) {
//            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
//        }
//
//        HashMap<String, Integer> freq = new HashMap<>();
//
//        for (String word : s.split(" ")) {
//            freq.put(word, freq.getOrDefault(word, 0) + 1);
//        }
//
//        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
//            System.out.println(e.getKey() + " -> " + e.getValue());
//        }
//
//        for (int x : arr) {
//            if (freq.get(x) == 1) {
//                System.out.println(x);
//            }
//        }
//
//        for (int x : arr) {
//            if (freq.get(x) == 1) {
//                System.out.println(x);
//                break;
//            }
//        }
//
//        int max = 0;
//        int ans = -1;
//
//        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
//            if (e.getValue() > max) {
//                max = e.getValue();
//                ans = e.getKey();
//            }
//        }
//
//        int min = Integer.MAX_VALUE;
//        int ans = -1;
//
//        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
//            if (e.getValue() < min) {
//                min = e.getValue();
//                ans = e.getKey();
//            }
//        }
//
//        PriorityQueue<Integer> pq =
//                new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
//
//        for (int x : freq.keySet()) {
//            pq.add(x);
//            if (pq.size() > k) pq.poll();
//        }
//
//        HashMap<Character, Integer> freq = new HashMap<>();
//
//        for (char c : s.toCharArray())
//            freq.put(c, freq.getOrDefault(c, 0) + 1);
//
//        for (char c : t.toCharArray())
//            freq.put(c, freq.get(c) - 1);
//
//        for (int val : freq.values())
//            if (val != 0) return false;
//
//        freq.put(x, freq.getOrDefault(x, 0) + 1);
//
//        Time  : O(N)
//        Space : O(N)

    }
}

//public static void main(String[] args) {
//    String s = "programming";
//    HashMap<Character, Integer> map = new HashMap<>();
//
//    for (char ch : s.toCharArray()) {
//        if (map.containsKey(ch)) {
//            System.out.println(ch);
//            return;
//        }
//        map.put(ch, 1);
//    }
//
//    System.out.println("No repeating char");
//}

//import java.util.*;
//
//public class FreqHashMap {
//    public static void main(String[] args) {
//        String s = "aabB#1a";
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (char ch : s.toCharArray()) {
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//
//        for (char key : map.keySet()) {
//            System.out.println(key + " -> " + map.get(key));
//        }
//    }
//}
