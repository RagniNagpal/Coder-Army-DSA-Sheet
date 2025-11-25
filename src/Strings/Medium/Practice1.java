package Strings.Medium;

import java.util.*;

public class Practice1 {

    // 1️⃣ First non-repeating character
    public char firstNonRepeating(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean repeat = false;
            for (int j = 0; j < n; j++) {
                if (i != j && arr[i] == arr[j]) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                return arr[i];
            }
        }
        return '\0'; // means no non-repeating char
    }

    // 2️⃣ Group Anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);

            map.putIfAbsent(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // 3️⃣ Check rotation of string
    public String checkRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return "Not rotation (different lengths)";

        if (s1.equals(s2)) return "Not rotated (exact same string)";

        // rotation check logic
        String s3 = s2 + s2;
        if (s3.contains(s1)) {
            return "Rotated version";
        } else {
            return "Not rotation";
        }
    }

    // 4️⃣ Remove all occurrences of substring
    class Solution {
        public String removeOccurrences(String s, String part) {
            StringBuilder sb = new StringBuilder(s);

            // Jab tak "part" substring present hai, delete karte raho
            while (sb.indexOf(part) != -1) {
                int index = sb.indexOf(part);
                sb.delete(index, index + part.length());
            }
            return sb.toString();
        }
    }

    // 5️⃣ String Compression (Run-Length Encoding)
    public String stringcomp(String input) {
        if (input == null || input.isEmpty()) return "";
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                result.append(input.charAt(i));
                if (count > 1) {
                    result.append(count);
                }
                count = 1; // reset count
            }
        }

        return result.toString();
    }

    // 1️⃣ Find First & Last Occurrence of Character or Substring
    public void findOccurrences(String s, String part) {
        int first = s.indexOf(part);
        int last = s.lastIndexOf(part);

        if (first == -1) {
            System.out.println("Substring not found!");
        } else {
            System.out.println("First occurrence of '" + part + "': " + first);
            System.out.println("Last occurrence of '" + part + "': " + last);
        }
    }
    // 2️⃣ Check if Substring Exists
    public void checkSubstring(String s, String part) {
        if (s.contains(part)) {
            System.out.println("'" + part + "' exists in '" + s + "'");
        } else {
            System.out.println("'" + part + "' does not exist in '" + s + "'");
        }
    }

    // 🔹 Main function
    public static void main(String[] args) {
        Practice1 obj = new Practice1();

        // 1️⃣ Non-repeating
        String str = "aabbcdeff";
        System.out.println("First non-repeating: " + obj.firstNonRepeating(str)); // c

        // 2️⃣ Group anagrams
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Grouped Anagrams: " + obj.groupAnagrams(words));

        // 3️⃣ Rotation test
        System.out.println("Check Rotation: " + obj.checkRotation("abcd", "cdab"));
        System.out.println("Check Rotation: " + obj.checkRotation("abcd", "abcd"));
        System.out.println("Check Rotation: " + obj.checkRotation("abcd", "bcda"));

        // 4️⃣ Remove Occurrences
        Practice1.Solution rem = obj.new Solution();
        System.out.println("Removed substring: " + rem.removeOccurrences("daabcbaabcbc", "abc")); // Output: "dab"

        // 5️⃣ String Compression
        String input = "aaabbbbcc";
        System.out.println("Compressed: " + obj.stringcomp(input)); // a3b4c2


        // 2️⃣ Substring Exists
        System.out.println("\n---- Check Substring ----");
        obj.checkSubstring("programming", "gram");
        obj.checkSubstring("hello", "bye");

        // 3️⃣ Longest Palindromic Subsequence
//        System.out.println("\n---- Longest Palindromic Subsequence ----");
//        String s1 = "bbbab";
//        System.out.println("Input: " + s1);
//        System.out.println("LPS length: " + obj.longestPalindromicSubsequence(s1)); // 4 ("bbbb")
//
//        // 4️⃣ Count Palindromic Substrings
//        System.out.println("\n---- Count Palindromic Substrings ----");
//        String s2 = "aba";
//        System.out.println("Input: " + s2);
//        System.out.println("Total palindromic substrings: " + obj.countPalindromicSubstrings(s2)); // 4
    }
}

