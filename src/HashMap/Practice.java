package HashMap;
import java.util.*;

public class Practice {
    static void countFrequency(String str) {
        // Write your code here
        //for oredr
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Print character and its frequency
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "" + entry.getValue() + " ");
        }

    }

    //max freq
//    for (int x : nums) {
//        map.put(x, map.getOrDefault(x, 0) + 1);
//    }
//
//    int maxFreq = 0;
//for (int freq : map.values()) {
//        maxFreq = Math.max(maxFreq, freq);
//    }
//
//    int result = 0;
//for (int freq : map.values()) {
//        if (freq == maxFreq) result += freq;
//    }

    //Substring with same first and last characters
//    public static int countSub()
    public static void main(String[] args) {

    }
}
