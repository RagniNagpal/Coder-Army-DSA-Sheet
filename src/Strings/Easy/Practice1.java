package Strings.Easy;
import java.util.*;

public class Practice1 {
    //reverse
    public String reverse(String s){
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);

    }
    public String reverse2(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();

    }

    //palindrome
    public Boolean palindrome(String s){
        String result = reverse2(s);
        if(s.equals(result)){
            return true;
        }else{
            return false;
        }
    }

    //count vowels,consonents,digits, spaces
    public void count(String s){
        int vowels = 0;
        int spaces = 0;
        int digits = 0;
        int consonants = 0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if (ch == 'a' || ch == 'A' || ch == 'E' || ch == 'e' ||
                    ch == 'i' || ch == 'I' || ch == 'O' || ch == 'o' ||
                    ch == 'u' || ch == 'U') {
                vowels++;
            } else if(ch==' '){
                spaces++;
            }
            else if(ch>='0' && ch<='9'){
                digits++;
            }
            else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);
    }
    public String removespace(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            // Keep letters and digits only
            if (!Character.isLetterOrDigit(ch)) {
                sb.deleteCharAt(i);
                i--; // adjust index after deletion
            }
        }

        return sb.toString();
    }

    //anagrams
    public boolean anagram(String str1, String str2) {
        if(str1.length() != str2.length()) return false; // quick length check

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    //find freq
    public void freq(String s){
        StringBuilder sb=new StringBuilder(s);
        int[] freq=new int[26];
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(ch>='a' && ch<='z'){
                freq[ch-'a']++;
            }
            else if (ch >= 'A' && ch <= 'Z') {
                freq[ch - 'A']++;
            }
        }
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                System.out.println((char)(i+'a') + "=" + freq[i]);
            }
        }
    }

    //uppercase/lowercase
    public void convert(String s){
        StringBuilder sb=new StringBuilder(s);
        int[] freq = new int[26];
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(ch>='A' && ch<='Z'){
                freq[ch-'A']++;
            }
            else if(ch >= 'a' && ch <= 'z'){
                freq[ch - 'a']++;
            }
        }
    }
    public String toUpperCaseManual(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            // lowercase a-z → convert to uppercase
            if (ch >= 'a' && ch <= 'z') {
                sb.setCharAt(i, (char)(ch - 32));
            }
        }
        return sb.toString();
    }

    //duplicate ch
    public void dupCh(String s){
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z') freq[ch - 'a']++;
            else if(ch >= 'A' && ch <= 'Z') freq[ch - 'A']++;
        }
        System.out.println("Duplicate characters:");
        for(int i = 0; i < 26; i++){
            if(freq[i] > 1) System.out.println((char)(i + 'a') + " = " + freq[i]);
        }
    }

    public String toggle(String s){
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(ch>='A' && ch<='Z'){
                sb.setCharAt(i, Character.toLowerCase(ch));
            }
            else {
                sb.setCharAt(i, Character.toUpperCase(ch));

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Practice1 obj = new Practice1();
        String str = "hello";
        System.out.println(obj.reverse(str));
        System.out.println(obj.reverse2(str));
        System.out.println(obj.palindrome("madam"));
        String str2 = "abc 123";
        obj.count(str2);
        System.out.println(obj.removespace("he@ll o!"));
        String s1 = "listen";
        String s2 = "silent";
        System.out.println(obj.anagram(s1, s2));
        String s = "apple";
        obj.freq(str);
        String strr = "HeLLo WorLD";
        System.out.println(obj.toUpperCaseManual(strr)); // Output: HELLO WORLD
//        System.out.println(obj.convert(strr));
        obj.dupCh("programming");
        String strrr = "HeLLo WorLD 123!";
        System.out.println(obj.toggle(strrr));
    }
}
