package Strings.PracticeeMore;
import java.util.*;

public class MoreeStrings {

    // 1️⃣ Character-level reverse
    public String reverseCharacters(String s){
        String[] arr = s.trim().split("\\s+");
        int left = 0, right = arr.length - 1;
        while(left < right){
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        String result = String.join(" ", arr);
        return result;
    }

    // 2️⃣ Word-level reverse
    public String reverseWordsInSentence(String s){
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    // 3️⃣ Remove consecutive duplicates
    public String removeConDup(String s){
        if(s.length() == 0) return s;
        StringBuilder sb=new StringBuilder();
        sb.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    // 4️⃣ Check palindrome (simple)
    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    // 5️⃣ Count all palindromic substrings
    public static int countPalindromes(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub)) {
                    count++;
                }
            }
        }
        return count;
    }

    // 6️⃣ Longest substring without repeating characters
    public static String longestUniqueSubstring(String s) {
        String maxSub = "";
        String current = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int idx = current.indexOf(ch);
            if (idx != -1) {
                current = current.substring(idx + 1);
            }

            current += ch;

            if (current.length() > maxSub.length()) {
                maxSub = current;
            }
        }

        return maxSub;
    }

    // 7️⃣ Generate all subsequences
    static void generateSubsequences(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = s.charAt(0);
        String rest = s.substring(1);

        generateSubsequences(rest, ans + ch); // include
        generateSubsequences(rest, ans);       // exclude
    }

    // 8️⃣ Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            while(j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j);
            if(prefix.equals("")) return "";
        }
        return prefix;
    }

    // 9️⃣ Check palindrome ignoring non-letter characters
    public boolean isPalindromee(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;

            left++;
            right--;
        }
        return true;
    }

    // 🔟 Count and Say Problem
    public String countAndSay(int n) {
        String result = "1";

        for(int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j = 1; j < result.length(); j++) {
                if(result.charAt(j) == result.charAt(j-1)) {
                    count++;
                } else {
                    sb.append(count).append(result.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count).append(result.charAt(result.length() - 1));
            result = sb.toString();
        }
        return result;
    }

    // 🔹 Main function
    public static void main(String[] args) {
        MoreeStrings obj = new MoreeStrings();

        String sentence = "I love Java";

        // Character-level reverse
        System.out.println("Character-level reverse: " + obj.reverseCharacters(sentence));

        // Word-level reverse
        System.out.println("Word-level reverse: " + obj.reverseWordsInSentence(sentence));

        // Remove consecutive duplicates
        String dup = "aaabbbccaaa";
        System.out.println("Remove consecutive duplicates: " + obj.removeConDup(dup));

        // Palindrome check
        String pal = "aba";
        System.out.println("Is palindrome: " + isPalindrome(pal));

        // Count all palindromic substrings
        System.out.println("Total palindromic substrings in 'aba': " + countPalindromes(pal));

        // Longest unique substring
        String s = "abcabcbb";
        System.out.println("Longest unique substring: " + longestUniqueSubstring(s));

        // Generate all subsequences
        System.out.println("All subsequences of 'abc':");
        generateSubsequences("abc", "");

        // Longest Common Prefix
        String[] arr = {"flower","flow","flight"};
        System.out.println("Longest common prefix: " + obj.longestCommonPrefix(arr));

        // Check palindrome ignoring non-letters
        String str = "A man, a plan, a canal: Panama";
        System.out.println("Is palindrome ignoring non-letters: " + obj.isPalindromee(str));

        // Count and Say
        int n = 5;
        System.out.println("Count and Say for n=5: " + obj.countAndSay(n));
    }
}
