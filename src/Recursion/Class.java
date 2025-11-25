package Recursion;

import java.sql.SQLOutput;

public class Class {

    // Method to start tossing coins
    public static void coinToss(int n) {
        toss(n, "");
    }

    // Recursive method to generate all outcomes
    public static void toss(int n, String ans) {
        if(n == 0) {
            System.out.println(ans);
            return;
        }
        toss(n-1, ans + "H");
        toss(n-1, ans + "T");
    }

    public static void main(String[] args) {
        int n = 3; // number of coins
        coinToss(n);
    }
}




