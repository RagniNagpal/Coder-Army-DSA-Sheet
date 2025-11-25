package DP;

public class MinSubDiff {

    // Returns the DP table for subset sum possible
    public boolean[][] subsetSumTable(int[] arr, int sum, int n){
        boolean[][] t = new boolean[n+1][sum+1];

        for (int i = 0; i <= n; i++) t[i][0] = true;
        for (int j = 1; j <= sum; j++) t[0][j] = false;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t;
    }

    // Minimum Subset Sum Difference
    public int minimumSubsetSumDifference(int[] arr){
        int n = arr.length;
        int sum = 0;
        for(int x : arr) sum += x;

        boolean[][] t = subsetSumTable(arr, sum, n);
        int minDiff = Integer.MAX_VALUE;

        for(int s1 = 0; s1 <= sum/2; s1++){
            if(t[n][s1]){
                minDiff = Math.min(minDiff, sum - 2*s1);
            }
        }
        return minDiff;
    }

    // Count subsets that form the minimum difference
    public int countSubsetsForMinDiff(int[] arr){
        int n = arr.length;
        int sum = 0;
        for(int x : arr) sum += x;

        boolean[][] t = subsetSumTable(arr, sum, n);

        int minDiff = Integer.MAX_VALUE;
        int bestS1 = 0;
        for(int s1 = 0; s1 <= sum/2; s1++){
            if(t[n][s1]){
                int diff = sum - 2*s1;
                if(diff < minDiff){
                    minDiff = diff;
                    bestS1 = s1;
                }
            }
        }

        // Count DP table
        int[][] count = new int[n+1][bestS1+1];
        for(int i=0;i<=n;i++) count[i][0] = 1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=bestS1;j++){
                count[i][j] = count[i-1][j]; // not take
                if(arr[i-1] <= j){
                    count[i][j] += count[i-1][j - arr[i-1]]; // take
                }
            }
        }

        return count[n][bestS1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        MinSubDiff obj = new MinSubDiff();

        System.out.println("Minimum Subset Sum Difference = " +
                obj.minimumSubsetSumDifference(arr));

        System.out.println("Subsets count for Minimum Difference = " +
                obj.countSubsetsForMinDiff(arr));
    }
}

//✅ Time Complexity: O(n * sum)
//✅ Space Complexity: O(n * sum)