package DP;

import java.util.*;

public class CountSubSetSum {

    // DP table global so print function use kar sake
    static int[][] t;

    public int subsetSumCount(int[] arr, int sum, int n){
        t = new int[n+1][sum+1];

        for (int i = 0; i <= n; i++)
            t[i][0] = 1;

        for (int j = 1; j <= sum; j++)
            t[0][j] = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }

    // Backtrack to print subsets
    public void printSubsets(int[] arr, int i, int sum, List<Integer> current) {
        if (i == 0 && sum != 0 && t[0][sum] == 0)
            return;

        // If sum becomes 0 → print subset
        if (sum == 0) {
            System.out.println(current);
            return;
        }

        // Exclude current element
        if (t[i-1][sum] > 0)
            printSubsets(arr, i-1, sum, new ArrayList<>(current));

        // Include current element
        if (sum >= arr[i-1] && t[i-1][sum - arr[i-1]] > 0) {
            current.add(arr[i-1]);
            printSubsets(arr, i-1, sum - arr[i-1], new ArrayList<>(current));
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;
        int n = arr.length;

        CountSubSetSum cs = new CountSubSetSum();
        int count = cs.subsetSumCount(arr, sum, n);

        System.out.println("Count = " + count);
        System.out.println("Subsets:");
        cs.printSubsets(arr, n, sum, new ArrayList<>());
    }
}
