package DP;
import java.util.*;

public class KnapSackZeroOne {
    public int KnapSack(int[] val,int[] wt, int w, int n){
        int[][] t=new int[n+1][w+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
//                if(i==0 ||j==0){
//                    t[i][j]=0;
//                }
                if(wt[i-1]<=j){
                    t[i][j]=Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]],(t[i-1][j]));
                }
                else{
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][w];
    }
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;

        KnapSackZeroOne ks = new KnapSackZeroOne();
        System.out.println(ks.KnapSack(val, wt, W, n));
    }
}
