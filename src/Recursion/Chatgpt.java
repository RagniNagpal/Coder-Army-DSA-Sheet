package Recursion;

public class Chatgpt {

    // Print numbers from 1 to n (ascending)
    public void printAscending(int n) {
        if (n == 0) return;
        printAscending(n - 1);
        System.out.println(n);
    }

    // Print numbers from n to 1 (descending)
    public void printDescending(int n) {
        if (n == 0) return;
        System.out.println(n);
        printDescending(n - 1);
    }

    //factorial
    public int fact(int n){
        if(n==0 || n==1) return 1;
        return n * fact(n-1);
    }

    //Power of a number a^b
    public int pow(int a, int b){
        if(b==0) return 1;
        return a * pow(a,b-1);
    }

    //reverse no
    public void reverse(int n){
        if(n==0) return ;
        System.out.print(n%10);
        reverse(n/10);
    }

    //count digits of no
    public int countDigits(int n) {
        return helper(n);
    }
    public int helper(int n){
        if(n==0) return 0;
        return 1+ helper(n/10);
    }

    //sum of first n natural no
    public int naturalNo(int n){
        if(n==0) return 0;
        return n + naturalNo(n - 1);
    }

    //Print array elements recursively
    public void printArray(int[] arr,int idx){
        if(idx>=arr.length) return;
        System.out.println(arr[idx]);
        printArray(arr,idx+1);
    }

    //Print array elements recursively reverse
    public void printArrayRev(int[] arr,int idx){
        if(idx<0) return;
        System.out.println(arr[idx]);
        printArray(arr,idx-1);
    }

    //Find max / min element
    public int findMax(int[] arr,int idx){
        if(idx==arr.length-1){
            return arr[idx];
        }
        int max=findMax(arr,idx+1);
        return Math.max(arr[idx],max);
    }

    //issorted
    class Solution {

        public boolean isSorted(int[] arr) {
            return isSortedHelper(arr, 0);
        }
        private boolean isSortedHelper(int[] arr, int idx) {
            // code here
            if(idx==arr.length-1){
                return true;
            }
            if (arr[idx] > arr[idx + 1]) return false;
            return isSortedHelper(arr, idx + 1);

        }

    }


    //Strings

    //Check if string is palindrome

        public boolean isPalindrome(String s) {
            return recCheck(s, 0, s.length() - 1);
        }

        private boolean recCheck(String s, int start, int end) {
            // base case
            if (start >= end) return true;

            if (s.charAt(start) != s.charAt(end)) return false;

            return recCheck(s, start + 1, end - 1);

    }

    //count vowels in string;
    public int vowels(String s){
        return helper(s.toLowerCase(), 0);
    }
    public int helper(String s,int i){
        if (i == s.length()) return 0; // base case

        char ch = s.charAt(i);
        int countForThis = (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') ? 1 : 0;

        return countForThis + helper(s, i + 1);
    }

    // Remove duplicates from string
    public String removeDup(String s){
       return rem(s,0,"");
    }
    public String rem(String s,int idx,String result){
        if(idx==s.length()) return result;
        char c = s.charAt(idx);
        if (result.indexOf(c) == -1) { // if not already in result
            result += c;
        }
        return rem(s,idx+1,result);
    }

//    Generate all subsequences of a string
    public void subsequence(String s,int idx,String ans){
        if(idx==s.length()){
            System.out.println(ans);
            return;
        }
        subsequence(s,idx+1,ans+s.charAt(idx));
        subsequence(s,idx+1,ans);
}

//    Print all subsets of a string
//same as subsequence

        public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
            return solve(arr, 0, K);
        }

        static boolean solve(int[] arr, int index, int target) {
            if (target == 0) return true;
            if (index == arr.length) return false;

            boolean include = solve(arr, index + 1, target - arr[index]);
            boolean exclude = solve(arr, index + 1, target);

            return include || exclude;
        }


//    Count distinct subsequences
//tle

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m) return 0;
        return helper(n - 1, m - 1, s, t);
    }

    private int helper(int i, int j, String s, String t) {
        if (j < 0) return 1;
        if (i < 0) return 0;

        if (s.charAt(i) == t.charAt(j)) {
            return helper(i - 1, j - 1, s, t) + helper(i - 1, j, s, t);
        } else {
            return helper(i - 1, j, s, t);
        }
    }


    //LCM using recursion
    class GfG {

        static int lcm(int a, int b) {

            // Larger value
            int g = Math.max(a, b);

            // Smaller value
            int s = Math.min(a, b);

            for (int i = g; i <= a * b; i += g) {
                if (i % s == 0)
                    return i;
            }
            return a * b;
        }

        public static void main(String[] args) {
            int a = 10, b = 5;
            System.out.println(lcm(a, b));
        }
    }

    public static void main(String[] args) {
        Chatgpt obj = new Chatgpt();
        int n = 5;

        System.out.println("Ascending:");
        obj.printAscending(n);  // Output: 1 2 3 4 5

        System.out.println("Descending:");
        obj.printDescending(n); // Output: 5 4 3 2 1

        System.out.println("Sum of first " + n + " natural numbers:");
        System.out.println(obj.naturalNo(n));  // Output: 15

        System.out.println("fact " + n + " :");
        System.out.println(obj.fact(n));

        System.out.println(obj.pow(2,5));
        System.out.print("Reverse: ");
        obj.reverse(12345); // just prints 54321
        System.out.println("Number of digits in " + n + ": " + obj.countDigits(12345));

        int[] arr = {2, 5, 7, 10, 15};
        System.out.println("Array elements:");
        obj.printArray(arr, 0);
        System.out.println("Array elements:");
        obj.printArrayRev(arr, arr.length-1 );

    }
}
