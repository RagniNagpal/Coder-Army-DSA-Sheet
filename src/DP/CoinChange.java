package DP;
import java.util.*;

public class CoinChange {
    public static int coinChange2(int[] coins, int amount){
        int n = coins.length;

        int[][] t = new int[n+1][amount+1];

        // initialization:
        // amount 0 → only 1 way (choose nothing)
        for(int i=0; i<=n; i++){
            t[i][0] = 1;
        }

        // 0 coins but positive amount → no way
        for(int j=1; j<=amount; j++){
            t[0][j] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=amount; j++){
                if(coins[i-1] <= j){
                    // include (same i) + exclude (previous i)
                    t[i][j] = t[i][j - coins[i-1]] + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][amount];
    }

    public static void main(String[] args){
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(coinChange2(coins, amount)); // output = 4
    }
}

//agar min, max or kuch bhi aaye .....to phir uska 1+ add kardo ye likhne ki zarurat nhi hai