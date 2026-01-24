//package DP;
//import java.util.*;
//public class Revision {
//    //knapsack
//    public int Knapsack(int val[],int[] wt, int w,int n){
//        int[][] t=new int[n+1][w+1];
//        for(int i=1;i<n+1;i++){
//            for(int j=1;j<w+1;j++){
//                if(wt[i-1] <= j){
//                    t[i][j]=Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]],(t[i-1][j]));
//                }
//                else{
//                    t[i][j]=t[i-1][j];
//                }
//            }
//        }
//        return t[n][w];
//    }
//    //subset sum
//    public boolean subset(int[] arr,int sum,int n){
//        boolean[][] t=new boolean[n+1][sum+1];
//        for (int i = 0; i <= n; i++) {
//            t[i][0] = true;
//        }
//        for (int j = 1; j <= sum; j++) {
//            t[0][j] = false;
//        }
//
//        for(int i=1;i<n+1;i++){
//            for(int j=1;j<sum+1;j++){
//                if(arr[i-1] <= j){
//                    t[i][j]= t[i - 1][j - arr[i - 1]] || t[i-1][j];
//                }
//                else{
//                    t[i][j]=t[i-1][j];
//                }
//            }
//        }
//        return t[n][sum];
//    }
//    //equal sum partition
//    public boolean partition(int[] arr,int n){
//        int sum=0;
//        for(int x:arr){
//            sum+=x;
//        }
//        if(sum%2!=0) return false;
//        int target=sum/2;
//        boolean[][] t=new boolean[n+1][target+1];
//        for(int i=1;i<n+1;i++){
//            for(int j=1;j<target+1;j++){
//                if(arr[i-1] <= j){
//                    t[i][j]= t[i - 1][j - arr[i - 1]] || t[i-1][j];
//                }
//                else{
//                    t[i][j]=t[i-1][j];
//                }
//            }
//        }
//        return t[n][sum];
//    }
//    //count of subset of given sum
//    public int Countsubset(int[] arr,int sum,int n){
//        int[][] t=new int[n+1][sum+1];
//        for (int i = 0; i <= n; i++) {
//            t[i][0] = 1;
//        }
//        for (int j = 1; j <= sum; j++) {
//            t[0][j] = 0;
//        }
//
//        for(int i=1;i<n+1;i++){
//            for(int j=1;j<sum+1;j++){
//                if(arr[i-1] <= j){
//                    t[i][j]= t[i - 1][j - arr[i - 1]] + t[i-1][j];
//                }
//                else{
//                    t[i][j]=t[i-1][j];
//                }
//            }
//        }
//        return t[n][sum];
//    }
//    //print subsets
//    public void printSubsets(int[] arr, int i,int sum,List<Integer> current){
//        if(i==0 && sum!=0 && t[0][sum]==0) return;
//        if(sum==0){
//            System.out.println(current);
//            return;
//        }
//        if(t[i-1][sum] > 0){
//
//        }
//    }
//    public static void main(String[] args) {
//
//    }
//}
