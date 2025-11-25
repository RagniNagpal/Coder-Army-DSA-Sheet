package SlidingWindow;

import java.util.*;

public class Introduction {
    public static void main(String[] args) {

        // ---------------------------
        // 🧮 1. Max Sum Subarray of Size K (Fixed Window)
        // ---------------------------
        int[] arr1 = {1, 5, 4, 2, 9, 9, 9};
        int k1 = 3;
        int sum = 0, i = 0, j = 0;
        int maxSum = Integer.MIN_VALUE;

        while (j < arr1.length) {
            sum += arr1[j];

            if (j - i + 1 < k1) {       // < k → expand window
                j++;
            } else if (j - i + 1 == k1) { // == k → valid window
                maxSum = Math.max(maxSum, sum);
                sum -= arr1[i];          // > k → shrink window
                i++;
                j++;
            }
        }
        System.out.println("1️⃣ Maximum Sum of subarray of size " + k1 + " is: " + maxSum);

        // ---------------------------
        // ❄️ 2. First Negative Number in Every Window of Size K (without Deque)
        // ---------------------------
        int[] arr2 = {12, -1, -7, 8, -15, 30, 16, 28};
        int k2 = 3;
        List<Integer> negatives = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        i = 0; j = 0;

        while (j < arr2.length) {
            if (arr2[j] < 0) negatives.add(arr2[j]);

            if (j - i + 1 < k2) {       // < k → expand
                j++;
            } else if (j - i + 1 == k2) { // == k → valid window
                result.add(!negatives.isEmpty() ? negatives.get(0) : 0);
                if (!negatives.isEmpty() && arr2[i] == negatives.get(0)) negatives.remove(0);
                i++; j++;                 // > k → shrink
            }
        }
        System.out.println("2️⃣ First negative number in each window: " + result);

        //--------------------------------------------//
        // 🔠 3. Count Occurrences of Anagrams
        //--------------------------------------------//
        String txt = "forxxorfxdofr";
        String pat = "for";
        int n = txt.length();
        int k = pat.length();

        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : pat.toCharArray()) freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        int count = freq.size();
        int ans = 0;
        i = 0; j = 0;

        while (j < n) {
            char ch = txt.charAt(j);
            if (freq.containsKey(ch)) {
                freq.put(ch, freq.get(ch) - 1);
                if (freq.get(ch) == 0) count--;
            }

            if (j - i + 1 < k) {         // < k → expand
                j++;
            } else if (j - i + 1 == k) { // == k → valid
                if (count == 0) ans++;
                char left = txt.charAt(i);
                if (freq.containsKey(left)) {
                    freq.put(left, freq.get(left) + 1);
                    if (freq.get(left) == 1) count++;
                }
                i++; j++;                 // > k → shrink
            }
        }
        System.out.println("3️⃣ Count of anagrams of '" + pat + "' in '" + txt + "' = " + ans);

        // ---------------------------
        // ☀️ 4. Maximum of all subarrays of size K (without deque)
        // ---------------------------
        int[] arr3 = {12, -1, -7, 8, -15, 30, 16, 28};
        int k3 = 3;
        List<Integer> maxList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        i = 0; j = 0;

        while (j < arr3.length) {
            if (arr3[j] > max) max = arr3[j];

            if (j - i + 1 < k3) {        // < k → expand
                j++;
            } else if (j - i + 1 == k3) { // == k → valid
                maxList.add(max);
                if (arr3[i] == max) {     // > k → recalc max when leaving
                    max = Integer.MIN_VALUE;
                    for (int p = i + 1; p <= j; p++) if (arr3[p] > max) max = arr3[p];
                }
                i++; j++;
            }
        }
        System.out.println("4️⃣ Maximum of all subarrays of size " + k3 + " = " + maxList);

        // ---------------------------
        // 🪄 5. Variable Size Sliding Window - Largest Subarray of Sum K
        // ---------------------------
        int[] arr = {1, 2, 1, 1, 1, 3};
        k = 3;
        int currSum = 0;
        int maxLen = 0;
        i = 0; j = 0;

        while (j < arr.length) {
            currSum += arr[j];

            while (currSum > k && i <= j) currSum -= arr[i++]; // > k → shrink

            if (currSum == k) maxLen = Math.max(maxLen, j - i + 1); // == k → valid
            j++; // < k → expand
        }
        System.out.println("5️⃣ Length of largest subarray with sum " + k + " is: " + maxLen);

        // ---------------------------
        // 🧠 6. Longest Substring with K Unique Characters
        // ---------------------------
        String s6 = "aabacbebebe";
        k = 3;
        Map<Character, Integer> map = new HashMap<>();
        int maxi = 0;
        i = 0; j = 0;

        while (j < s6.length()) {
            map.put(s6.charAt(j), map.getOrDefault(s6.charAt(j), 0) + 1); // < k → expand

            while (map.size() > k) { // > k → shrink
                char leftChar = s6.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) map.remove(leftChar);
                i++;
            }

            if (map.size() == k) maxi = Math.max(maxi, j - i + 1); // == k → valid
            j++;
        }
        System.out.println("6️⃣ Longest substring with " + k + " unique characters = " + maxi);

        //------------------------------------------
        // 7️⃣ Longest Substring Without Repeating Characters
        //------------------------------------------
        String s7 = "abcabcbb";
        Set<Character> set = new HashSet<>();
        i = 0; j = 0;
        maxLen = 0;

        while (j < s7.length()) {
            char ch = s7.charAt(j);
            if (!set.contains(ch)) {    // < k → expand
                set.add(ch);
                j++;
                maxLen = Math.max(maxLen, j - i); // == k → valid
            } else {                     // > k → shrink
                set.remove(s7.charAt(i));
                i++;
            }
        }
        System.out.println("7️⃣ Length of Longest Substring Without Repeating Characters: " + maxLen);

        //------------------------------------------
        // 8️⃣ Minimum Window Substring
        //------------------------------------------
        String s8 = "ADOBECODEBANC";
        String t8 = "ABC";

        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : t8.toCharArray()) map1.put(c, map1.getOrDefault(c, 0) + 1);

        i = 0; j = 0;
        int minLen = Integer.MAX_VALUE;
        count = map1.size();
        int start = 0;

        while (j < s8.length()) {
            char ch = s8.charAt(j);
            if (map1.containsKey(ch)) {
                map1.put(ch, map1.get(ch) - 1);
                if (map1.get(ch) == 0) count--;
            }

            while (count == 0) { // == k → valid
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                char left = s8.charAt(i);
                if (map1.containsKey(left)) {
                    map1.put(left, map1.get(left) + 1);
                    if (map1.get(left) > 0) count++;
                }
                i++; // > k → shrink
            }
            j++; // < k → expand
        }

        String ans1 = (minLen == Integer.MAX_VALUE) ? "" : s8.substring(start, start + minLen);
        System.out.println("8️⃣ Minimum Window Substring: " + ans1);

//        🔍 Hinglish 3-Line Explanation (All 3 Conditions)
//
//                < k → window expand karte jao (j++) until all required chars match.
//
//                == k → valid window hai, minimum window update karo.
//
//                > k → shrink karo from left (i++) while still keeping window valid.
    }
}
