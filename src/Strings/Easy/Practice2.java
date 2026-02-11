package Strings.Easy;
import java.util.*;

public class Practice2 {
    //Frequency of characters
    public static void freq(String s){
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i] > 0){
                System.out.println((char)(i+'a') + "->" + freq[i]);
            }
        }
    }

    //first non repeating character
    public static void repChar(String s){
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a'] ==1){
                System.out.println(s.charAt(i));
                return;
            }
            System.out.println("No unique char");
        }
    }
    //even odd logic
    //can form palindrome
    //even full, odd count-1 sirf 1 odd allowed
    public static boolean canFormPalindrome(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int oddCount = 0;
        for (int f : freq) {
            if (f % 2 != 0)
                oddCount++;
        }

        return oddCount <= 1;
    }
    //count
    class Sol {
        int getCount(String S, int N) {
            int[] freq = new int[26];

            int i = 0;   // ✅ i declared
            while (i < S.length()) {

                char ch = S.charAt(i);   // ✅ ch declared
                freq[ch - 'a']++;        // ek occurrence count

                // skip consecutive same characters
                while (i < S.length() && S.charAt(i) == ch) {
                    i++;
                }
            }

            int count = 0;
            for (int x : freq) {
                if (x == N) {
                    count++;
                }
            }
            return count;
        }
    }

    //max occuring characters
    public char getMax(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);

        }
        int maxF=0;
        char maxChar=0;
        for( char c:map.keySet()){
            int freq=map.get(c);
            if(freq>maxF || (freq==maxF) && c<maxChar){
                maxF=freq;
                maxChar=c;

            }

        }
        return maxChar;
    }
    //remove Duplicates
    public static String remDup(String s){
        Set<Character> set=new HashSet<>();
        for(char ch:s.toCharArray()){
            set.add(ch);
        }
        StringBuilder sb=new StringBuilder();
        for(char ch:set){
            sb.append(ch);
        }
        return sb.toString();
    }

    //merge string
    public String merge(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        // merge alternately
        while (i < s1.length() && j < s2.length()) {
            sb.append(s1.charAt(i));
            sb.append(s2.charAt(j));
            i++;
            j++;
        }

        // remaining characters of s1
        while (i < s1.length()) {
            sb.append(s1.charAt(i));
            i++;
        }

        // remaining characters of s2
        while (j < s2.length()) {
            sb.append(s2.charAt(j));
            j++;
        }

        return sb.toString();
    }
//count

    static int countWords(String str) {

        if (str == null || str.trim().isEmpty()) {
            return 0;
        }

        String[] words = str.trim().split("\\s+");
        return words.length;
    }

//    public static void main(String[] args) {
//        String s = "abc";
//
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//                System.out.println(s.substring(i, j + 1));
//            }
//        }
//    }

    public static void printSubseq(String s, String ans, int index) {
        if (index == s.length()) {
            System.out.println(ans);
            return;
        }

        // Include current char
        printSubseq(s, ans + s.charAt(index), index + 1);

        // Exclude current char
        printSubseq(s, ans, index + 1);
    }

    public static void main(String[] args) {
        freq("hello");
        String s = "abcd";
        int n = s.length();
        int count = n * (n + 1) / 2; // formula
        System.out.println(count); // 10


    }
}
