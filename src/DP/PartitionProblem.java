package DP;
import java.util.*;

public class PartitionProblem {
    public boolean canPartition(int[] nums){
        int n=nums.length;
        int sum=0;
        for (int x : nums) sum += x;
        if(sum%2!=0) return false;
        int target=sum/2;
        boolean[][] t=new boolean[n+1][target+1];
        for(int i=0;i<=n;i++){
            t[i][0]=true;
        }
        for (int j = 1; j <= target; j++)
            t[0][j] = false;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                if(nums[i-1]<=j){
                    t[i][j]=t[i-1][j-nums[i-1]] || t[i-1][j];
                }
                else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][target];
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 8, 10};

        PartitionProblem pp = new PartitionProblem();

        System.out.println(pp.canPartition(nums));
    }
}
