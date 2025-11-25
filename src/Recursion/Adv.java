package Recursion;
import java.util.*;
import java.util.Collections;
public class Adv {

    // 🟩 Case 1: Reverse (Ulta) from arr,0
    public static void printReverseFromStart(int[] arr, int idx) {
        if (idx == arr.length) return;
        printReverseFromStart(arr, idx + 1);
        System.out.print(arr[idx] + " ");
    }

    // 🟩 Case 2: Forward (Seedha) from arr,0
    public static void printForwardFromStart(int[] arr, int idx) {
        if (idx == arr.length) return;
        System.out.print(arr[idx] + " ");
        printForwardFromStart(arr, idx + 1);
    }

    // 🟩 Case 3: Forward (Seedha) from arr,n-1
    public static void printForwardFromEnd(int[] arr, int idx) {
        if (idx < 0) return;
        printForwardFromEnd(arr, idx - 1);
        System.out.print(arr[idx] + " ");
    }

    // 🟩 Case 4: Reverse (Ulta) from arr,n-1
    public static void printReverseFromEnd(int[] arr, int idx) {
        if (idx < 0) return;
        System.out.print(arr[idx] + " ");
        printReverseFromEnd(arr, idx - 1);
    }

    //exists
    public static boolean exists(int[] arr, int target, int idx){
        if(idx==arr.length) return false;
        if(arr[idx]==target) return true;
        return exists(arr,target,idx+1);
    }
    //strings

//    String[] arr={"fghj","ghnm","uhfg"};
//    for(int i=0;i<arr.length;i++){
//        System.out.println(arr[i]);
//    }

    //subsets
    private static void subsets(String ans, String s, int idx){
        if(idx==s.length()){
            System.out.println(ans);
            return;
        }
        char ch=s.charAt(idx);
        subsets(ans+ch, s,idx+1);
        subsets(ans,s,idx+1);
    }

    //generate parenthesis0
    public void generate(int n, int l, int r, String s, List<String> ans) {
        if (r == n) { // all right parentheses are used
            ans.add(s);
            return;
        }

        // Add '(' if we still have some left
        if (l < n)
            generate(n, l + 1, r, s + "(", ans);

        // Add ')' if it won't make sequence invalid
        if (r < l)
            generate(n, l, r + 1, s + ")", ans);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, 0, 0, "", ans);
        return ans;
    }
    // Java code to compute nCr using Recursion
    class GfG {

        // Recursive function to calculate nCr
        static int nCr(int n, int r) {

            // Base Case 1: If r = 0 or r = n,
            // then nCr = 1
            if (r == 0 || r == n) {
                return 1;
            }

            // Base Case 2: If r = 1, then nCr = n
            if (r == 1) {
                return n;
            }

            // Recursive relation:
            // nCr = (n-1)C(r-1) + (n-1)Cr
            return nCr(n - 1, r - 1) + nCr(n - 1, r);
        }

        public static void main(String[] args) {

            int n = 5, r = 2;

            System.out.println(nCr(n, r));
        }
    }

    //preinPost

    //subset sum
    public void subset(int[] arr, int idx,int sum, ArrayList<Integer> list){
        if(idx==arr.length){
            list.add(sum);
            return;
        }
        subset(arr,idx+1,sum+arr[idx],list);
        subset(arr,idx+1,sum,list);
    }
    public ArrayList<Integer> subsetSum(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        subset(arr,0,0,list);
        Collections.sort(list);
        return list;
    }
    //tower of hanoi
//    public static void hanoi(int n, char a, char b, char c){
//        if(n==0) return;
//        hanoi(n-1, a, c,b) // n-1 diske from A TO B via c
//        System.out.println(a + "->" + c);
//        hanoi(n-1,b,a,c);
//    }
//    Move n-1 disks from source to auxiliary.
//
//    Move the largest disk from source to destination.
//
//    Move n-1 disks from auxiliary to destination.
//    Formula for Moves: Reveals the formula for the minimum number of moves: 2^n - 1.

    //power set
//import java.util.*;

    class Solution {
        // Recursive helper function
        public void subsets(String ans, String s, int idx, List<String> list) {
            if (idx == s.length()) {
                if (ans.length() != 0) list.add(ans);
                return;
            }

            char ch = s.charAt(idx);

            // Include current character
            subsets(ans + ch, s, idx + 1, list);

            // Exclude current character
            subsets(ans, s, idx + 1, list);
        }

        public List<String> AllPossibleStrings(String s) {
            List<String> list = new ArrayList<>();
            subsets("", s, 0, list);
            Collections.sort(list);
            return list;
        }
    }

    //first occ in bs with recursion
//        public int firstOcc(int[] nums, int low, int high, int target)
//        {
//            if(low > high) return -1;
//            int mid = low + (high - low) / 2;
//
//            if(nums[mid]==target) return mid;
//            else if(nums[mid]>target){
//                return firstOcc(nums,low,mid-1,target);
//            }
//            else if(nums[mid]<target){
//                return firstOcc(nums,mid+1,high,target);
//            }
//        }
//        public int searchRange(int[] nums, int target) {
//            int firstIndex = firstOcc(nums,0,nums.length-1,target);
//            return firstIndex;
//        }

    //Generate all binary strings
    public ArrayList<String> binstr(int n) {
        ArrayList<String> ans = new ArrayList<>();
        generate(0, n, "", ans);
        return ans;
    }

    // Recursive helper function
    private void generate(int idx, int n, String current, ArrayList<String> ans) {
        if (idx == n) {
            ans.add(current); // base case: string is complete
            return;
        }

        // Recurse by adding '0' at current position
        generate(idx + 1, n, current + "0", ans);

        // Recurse by adding '1' at current position
        generate(idx + 1, n, current + "1", ans);
    }

    // Generate Parentheses


//        public List<String> generateParenthesis(int n) {
//            ArrayList<String> ans = new ArrayList<>();
//            generate("", 0, 0, n, ans);
//            return ans;
//        }
//
//        private void generate(String current, int open, int close, int n, ArrayList<String> ans) {
//            // Base case: current string has 2*n characters
//            if(current.length() == 2 * n){
//                ans.add(current);
//                return;
//            }
//
//            // Add '(' if we still have some left
//            if(open < n){
//                generate(current + "(", open + 1, close, n, ans);
//            }
//
//            // Add ')' if it won’t exceed number of '('
//            if(close < open){
//                generate(current + ")", open, close + 1, n, ans);
//            }
//        }

    //

    //subset
    private List<List<Integer>> ans = new ArrayList<>();
    public void subsetsHelper(int[] nums,int i, List<Integer> temp){
        if(i >= nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        subsetsHelper(nums,i+1,temp);
        temp.add(nums[i]);
        subsetsHelper(nums,i+1,temp);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        subsetsHelper(nums, 0, temp);
        return ans;
    }

    //subset2

//        private List<List<Integer>> ans = new ArrayList<>();
//
//        public void subsetsHelper(int[] nums, int i, List<Integer> temp){
//            ans.add(new ArrayList<>(temp));
//
//            for(int j = i; j < nums.length; j++){
//
//                if(j > i && nums[j] == nums[j - 1]) continue;
//
//                temp.add(nums[j]);
//                subsetsHelper(nums, j + 1, temp);
//                temp.remove(temp.size() - 1);
//            }
//        }
//
//        public List<List<Integer>> subsetsWithDup(int[] nums) {
//            Arrays.sort(nums);
//            subsetsHelper(nums, 0, new ArrayList<>());
//            return ans;
//        }



//    17. Letter Combinations of a Phone Number

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            if (digits.length() == 0) return ans;
            helper(digits, 0, "", ans);
            return ans;
        }
        public void helper(String digits, int idx, String current, List<String> ans) {
            if (idx == digits.length()) {
                ans.add(current);
                return;
            }

            String letters = val(digits.charAt(idx));
            for (int i = 0; i < letters.length(); i++) {
                helper(digits, idx + 1, current + letters.charAt(i), ans);
            }
        }


        public String val(char ch) {
            if (ch == '1') return " ";
            if (ch == '2') return "abc";
            if (ch == '3') return "def";
            if (ch == '4') return "ghi";
            if (ch == '5') return "jkl";
            if (ch == '6') return "mno";
            if (ch == '7') return "pqrs";
            if (ch == '8') return "tuv";
            if (ch == '9') return "wxyz";
            return "";
        }

//    Count and Say sequence
//    Josephus problem


    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("🟢 Case 1: Reverse (Ulta) from arr,0 →");
        printReverseFromStart(arr, 0);

        System.out.println("\n\n🟢 Case 2: Forward (Seedha) from arr,0 →");
        printForwardFromStart(arr, 0);

        System.out.println("\n\n🟢 Case 3: Forward (Seedha) from arr,n-1 →");
        printForwardFromEnd(arr, arr.length - 1);

        System.out.println("\n\n🟢 Case 4: Reverse (Ulta) from arr,n-1 →");
        printReverseFromEnd(arr, arr.length - 1);

        int[] arrr={5,3,7,12,76,9,34,5};
        int target=76;
        System.out.println();
        System.out.println("exists?");
        System.out.println(exists(arrr,target,0));
    }
}
