package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Practice {

    // Subsets
    public static void subsets(int[] arr, int idx, List<Integer> curr){
        if(idx == arr.length){
            System.out.println(curr);
            return;
        }
        curr.add(arr[idx]);
        subsets(arr, idx + 1, curr);

        curr.remove(curr.size() - 1);
        subsets(arr, idx + 1, curr);
    }

    // Subsequences
    public static void subseq(int idx, String s, String curr){
        if(idx == s.length()){
            System.out.println(curr);
            return;
        }
        subseq(idx + 1, s, curr + s.charAt(idx)); // include
        subseq(idx + 1, s, curr);                 // exclude
    }

    // Count subsets with sum = k
    public static int count(int[] arr, int idx, int sum, int k){
        if(idx == arr.length){
            return sum == k ? 1 : 0;
        }

        int include = count(arr, idx + 1, sum + arr[idx], k);
        int exclude = count(arr, idx + 1, sum, k);

        return include + exclude;
    }

    // Print subsets with given sum and count them
    public static int count2(int[] arr, int idx, int sum, int k, List<Integer> curr){
        if(idx == arr.length){
            if(sum == k){
                System.out.println(curr);
                return 1;
            }
            return 0;
        }

        // include
        curr.add(arr[idx]);
        int include = count2(arr, idx + 1, sum + arr[idx], k, curr);

        // exclude
        curr.remove(curr.size() - 1);
        int exclude = count2(arr, idx + 1, sum, k, curr);

        return include + exclude;
    }

    //Generate all binary strings of length n
    public static void generate(int idx, int n,String res){
        if(idx==n){
            System.out.println(res);
            return;
        }
        generate(idx+1,n,res + "0");
        generate(idx+1,n,res + "1");
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        subsets(arr, 0, new ArrayList<>());

        System.out.println("---- Subsequence ----");
        String s = "Ragni";
        subseq(0, s, "");

        System.out.println("---- Count Subsets Sum ----");
        int k = 3;
        int ans = count(arr, 0, 0, k);
        System.out.println("Count = " + ans);

        System.out.println("---- Print Subsets With Sum ----");
        int ans2 = count2(arr, 0, 0, k, new ArrayList<>());
        System.out.println("Count = " + ans2);

        int n = 3;
        generate(0, n, "");
    }
}


//
//import java.util.*;
//
//class Solution {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        ArrayList<Integer> res = new ArrayList<>();
//        subsetsHelp(nums, 0, res, ans);
//        return ans;
//    }
//
//    public void subsetsHelp(int[] nums, int idx,
//                            ArrayList<Integer> res,
//                            List<List<Integer>> ans) {
//
//        if (idx == nums.length) {
//            ans.add(new ArrayList<>(res));
//            return;
//        }
//
//        // include
//        res.add(nums[idx]);
//        subsetsHelp(nums, idx + 1, res, ans);
//
//        // exclude (backtrack)
//        res.remove(res.size() - 1);
//        subsetsHelp(nums, idx + 1, res, ans);
//    }
//}
