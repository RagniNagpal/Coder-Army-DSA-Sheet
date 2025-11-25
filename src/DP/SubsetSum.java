package DP;

import java.util.*;
public class SubsetSum {
    public Boolean SubsetSum(int[] arr, int sum, int n){
    boolean[][] t = new boolean[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            t[0][j] = false;
        }
    for(int i=1;i<n+1;i++){
        for(int j=1;j<sum+1;j++){
            if(arr[i-1]<=j){
                t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];

            }else{
                t[i][j]= t[i - 1][j];
            }
        }
    }
        return t[n][sum];
}
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int sum = 11;
        int n = arr.length;

        SubsetSum ss = new SubsetSum();

        System.out.println(ss.SubsetSum(arr, sum, n));

    }
}
