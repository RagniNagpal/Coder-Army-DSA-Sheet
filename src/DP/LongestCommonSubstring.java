package DP;

public class LongestCommonSubstring {
    public int longestCommonsubstring(String a, String b){
        int n=a.length();
        int m=b.length();
        int[][] dp=new int[n+1][m+1];
        int maxLen=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {

    }
}
