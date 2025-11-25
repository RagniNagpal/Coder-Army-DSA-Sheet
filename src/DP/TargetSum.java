package DP;

public class TargetSum {

    public static int findTargetSumWays(int[] arr, int target){
        int total = 0;
        for(int x : arr){
            total += x;
        }

        // formula: S1 = (total + target)/2
        if((total + target) % 2 != 0 || total < Math.abs(target)){
            return 0;
        }

        int S = (total + target) / 2;
        return SubSum(arr, S);
    }

    public static int SubSum(int[] arr, int sum){
        int n = arr.length;

        int[][] t = new int[n + 1][sum + 1];

        // initialization
        for(int i = 0; i <= n; i++){
            t[i][0] = 1; // sum 0 banane ka 1 way
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int target = 3;

        System.out.println(findTargetSumWays(arr, target)); // Output: 5
    }
}
