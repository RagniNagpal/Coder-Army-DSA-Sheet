package Backtracking;

import java.sql.SQLOutput;
import java.util.*;
public class Easy {
    //print all subsets of a string
    public static void findSubsets(String str, String curr, int index){
        if(index==str.length()){
            System.out.println(curr);
            return;
        }
        findSubsets(str,curr+ str.charAt(index),index+1);
        findSubsets(str,curr,index+1);
    }

    //print all subsets of a string with back
    static void subsets(int[] arr, int index, List<Integer> curr) {
        if (index == arr.length) {
            System.out.println(curr);
            return;
        }

        // Include current element
        curr.add(arr[index]);
        subsets(arr, index + 1, curr);

        // Exclude (Backtrack)
        curr.remove(curr.size() - 1);
        subsets(arr, index + 1, curr);
    }
    //Generate All Permutations of a String
    public static void permut(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String rem=str.substring(0,i)+str.substring(i+1);
            permut(rem,ch+ans);
        }
    }

//    print  all substrings of a string
static void printSubstrings(String str, int start, int end) {
    if (start == str.length()) return;
    if (end == str.length() + 1) {
        printSubstrings(str, start + 1, start + 1);
        return;
    }
    System.out.println(str.substring(start, end));
    printSubstrings(str, start, end + 1);
}
//    Print Numbers 1 to N
    public static void print(int n){
        if(n==0) return;
        print(n-1);
        System.out.println(n + " ");
    }

    //subset sum
    public static void subsetSum(int[] arr, int index, int sum){
        if(index==arr.length){
            System.out.println(sum);
            return;
        }
        subsetSum(arr,index+1,sum+arr[index]);
        subsetSum(arr,index+1,sum);
    }
    //Print All Binary Strings of Length N
    public static void binaryStr(String str, int n){
        if(n==0){
            System.out.println(str);
            return;
        }
        binaryStr(str + "0",n-1);
        binaryStr(str + "1",n-1);
    }
//    Generate All Possible Coin Toss Outcomes
    public static void Toss(int n,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        Toss(n-1,str + "H");
        Toss(n-1,str+"T");
    }
    //All Paths in Grid
    public static void paths(int i,int j , int n, int m,String path){
        if(i==n-1 && j==m-1){
            System.out.println(path);
            return;
        }
        if (i >= n || j >= m) return;
        paths(i+1,j,n,m,path + "D");
        paths(i,j+1,n,m,path+"R");
    }
    //Print All Balanced Parentheses
    public static void solve(int open, int close, String str){
        if(open==0 && close==0){
            System.out.println(str);
            return;
        }
        if(open>0){
            solve(open-1,close,str+"(");
        }
        if(close > open){
            solve(open,close-1,str+")");
        }
    }
    //Letter Case Permutation
    public static void permute(String str, int index,String res){
        if(index==str.length()){
            System.out.println(res);
            return;
        }
        char ch=str.charAt(index);
        if(Character.isDigit(ch)){
            permute(str,index+1,res+ch);

        }else{
            permute(str, index + 1, res + Character.toLowerCase(ch));
            permute(str, index + 1, res + Character.toUpperCase(ch));

        }
    }
    //Generate All Subsequences of an Integer Array
    public static void subseq(int[] arr,int i,List<Integer> temp){
        if(i==arr.length){
            System.out.println(temp);
            return;
        }
        temp.add(arr[i]);
        subseq(arr,i+1,temp);
        temp.remove(temp.size()-1);
        subseq(arr,i+1,temp);
    }
    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str, "", 0);
        permut("ABC", "");
        int[] arr = {1, 2, 3};
        subsets(arr, 0, new ArrayList<>());
        printSubstrings("abc", 0, 1);
        print(5);
        int[] arr2 = {1, 2};
        subsetSum(arr2, 0, 0);
        binaryStr("",3);
        Toss(3, "");
        paths(0, 0, 2, 2, "");
        int n = 3;
        solve(n, n, "");
        permute("a1b", 0, "");
        subseq(arr, 0, new ArrayList<>());
    }
}
