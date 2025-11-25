package Recursion;

import java.util.*;

// ✅ Basics of Recursion Examples
public class Basics {

    /*
    // 🧠 Example 1: Infinite Recursive Calls (commented to prevent stack overflow)
    public static void main(String[] args) {
        ragni(); // infinite recursion — will cause StackOverflowError
    }

    public static void ragni() {
        System.out.println("hii");
        nagpal();
    }

    public static void nagpal() {
        System.out.println("hello");
        wow();
    }

    public static void wow() {
        System.out.println("heheh");
        ragni(); // again calls ragni() → infinite loop
    }
    */

    /*
    // 🧠 Example 2: Recursion Example - Print Numbers
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // print numbers from n → 1
        System.out.println("Printing numbers from n to 1:");
        printDescending(n);

        // print numbers from 1 → n
        System.out.println("\nPrinting numbers from 1 to n:");
        printAscending(1, n);
    }

    // 🔽 Recursive Function 1: Print n to 1
    public static void printDescending(int n) {
        if (n == 0) return;
        System.out.println(n);
        printDescending(n - 1);
    }

    // 🔼 Recursive Function 2: Print 1 to n
    public static void printAscending(int x, int n) {
        if (x > n) return;
        System.out.println(x);
        printAscending(x + 1, n);
    }
    */

    /*
    // Example: Global Variable
    static int x = 10;

    public static void main(String[] args) {
        System.out.println("Before calling fun(), x = " + x);
        fun();
        System.out.println("After calling fun(), x = " + x);
    }

    public static void fun() {
        x = 20;
    }


    // Example: Factorial of a number
    public static int fact(int n) {
        if(n == 0 || n == 1) return 1;
        return n * fact(n-1);
    }


    /*
    // Example: Reverse array using recursion
    public int reverse(int[] arr,int n) {
        reverse(arr,0,arr.length-1);
    }
    public int rev(int[] arr, int start, int end) {
        if(start>=end) return ;
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        rev(arr, start+1, end-1);
    }
    */

    // 🔹 Reverse number with recursion (prints reversed number)
//    public static void reverse(int num) {
//        System.out.print(num % 10);  // print last digit
//        if (num < 10) return;        // base case
//        reverse(num / 10);           // recursive call
//    }

    // 🔹 Sum of first n natural numbers (recursion)
    public static int naturalno(int n){
        if(n == 0) return 0;
        return n + naturalno(n-1);
    }

    //reverse Exponential Function
    //→ O(log b) time ✅ (using divide & conquer) optimised
    public long pow(long a, long b) {
        if (b == 0) return 1;
        long call = pow(a, b / 2);
        if (b % 2 == 0) return call * call;
        else return call * call * a;
    }
    /*------------------------------------------------------
    🔁 Example 9: Reverse a Number using Helper Function
    ------------------------------------------------------*/
    int reverseHelper(int n, int rev) {
        if (n == 0) return rev;                    // base case
        return reverseHelper(n / 10, rev * 10 + n % 10); // recursive step
    }

    int reverse(int n) {
        return reverseHelper(n, 0); // wrapper function
    }
    /*------------------------------------------------------
     🔥 Example 10: Reverse Exponentiation (n ^ reverse(n))
     ------------------------------------------------------*/
    public static class ReverseExponentiation {
        public static int pow(int a, int b) {
            if (b == 0) return 1;
            int half = pow(a, b / 2);
            return (b % 2 == 0) ? half * half : half * half * a;
        }

        public static int reverse(int n) {
            return helper(n, 0);
        }

        private static int helper(int n, int rev) {
            if (n == 0) return rev;
            return helper(n / 10, rev * 10 + n % 10);
        }

        public static int reverseExponentiation(int n) {
            int rev = reverse(n);
            return pow(n, rev);
        }

        public static void main(String[] args) {
            System.out.println("12 ^ reverse(12) = " + reverseExponentiation(12));
        }
    }

//    int helper(int n, int rev) {
//        if (n == 0) return rev;
//        return helper(n / 10, rev * 10 + n % 10);
//    }

    //→ O(b) time linear recursion
    int pow(int a, int b) {
        if (b == 0) return 1;
        return a * pow(a, b - 1);
    }

    public long reverseExponentiation(long n) {
        if (n == 10) return 10;
        return pow(n, n);
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a; // base case
        }
        return gcd(b, a % b); // recursive call
    }

    //fibonacci
    public int nthFibonacci(int n){
        if(n==0 || n==1) return n;
        return nthFibonacci(n-1) + nthFibonacci(n-2);
    }
    //nth stairs
    int countWays(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        return countWays(n-1) + countWays(n-2);
    }


//🕐 [47:29] – Global Variable Example
//
//    Example:

    static int i = 1;
    void print(int n) {
        if (i > n) return;
        System.out.println(i++);
        print(n);
    }
    // 🔹 Main method to test
    public static void main(String[] args) {
        int num = 12345;
        System.out.print("Reversed Number: ");
//        reverse(num);
        System.out.println();

        int n = 6;
        int sum = naturalno(n);
        System.out.println("Sum of first " + n + " natural numbers: " + sum);
    }
}
