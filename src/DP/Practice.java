package DP;

public class Practice {
    //knapsack 0/1
    public static void main(String[] args) {

    }
}
class Solution {
    int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int cost1 = dp[i - 1] + Math.abs(height[i] - height[i - 1]);

            int cost2 = Integer.MAX_VALUE;
            if (i - 2 >= 0) {
                cost2 = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            }

            dp[i] = Math.min(cost1, cost2);
        }

        return dp[n - 1];
    }
}
//class Solution {
//    public int climbStairs(int n) {
//        int[] t = new int[n + 1];
//        t[0] = 1;
//        t[1] = 1;
//        for(int i=2;i<=n;i++){
//            t[i]=t[i-1]+t[i-2];
//        }
//        return t[n];
//    }
//}


//class Solution {
//    public int rob(int[] nums) {
//        int n = nums.length;
//        if (n == 1) return nums[0];
//
//        // Case 1: loot houses 0 to n-2
//        int max1 = robLinear(nums, 0, n - 2);
//
//        // Case 2: loot houses 1 to n-1
//        int max2 = robLinear(nums, 1, n - 1);
//
//        return Math.max(max1, max2);
//    }
//
//    private int robLinear(int[] nums, int start, int end) {
//        int len = end - start + 1;
//        if (len == 0) return 0;
//        if (len == 1) return nums[start];
//
//        int[] dp = new int[len];
//        dp[0] = nums[start];
//        dp[1] = Math.max(nums[start], nums[start + 1]);
//
//        for (int i = 2; i < len; i++) {
//            int notInclude = dp[i - 1];
//            int include = dp[i - 2] + nums[start + i];
//            dp[i] = Math.max(notInclude, include);
//        }
//        return dp[len - 1];
//    }
//}
