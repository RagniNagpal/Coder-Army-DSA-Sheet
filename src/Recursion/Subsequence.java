package Recursion;
import java.util.*;
import java.util.Collections;
public class Subsequence {
    void subsequence(String s, int idx,String ans){
        if(idx==s.length()){
            System.out.println(ans);
            return;
        }
        subsequence(s,idx+1,ans+s.charAt(idx));
        subsequence(s,idx+1,ans);
    }

    //𝙋𝙖𝙩𝙩𝙚𝙧𝙣 𝟮 — Store in List (instead of printing)
//    if(idx==s.length()){
//        list.add(ans);
//        return;
//    }

    // 𝙋𝙖𝙩𝙩𝙚𝙧𝙣 𝟯 — With Conditions / Filtering
//    if (idx == n) {
//        if (sum == target) list.add(ans);
//        return;
//    }

    //𝙋𝙖𝙩𝙩𝙚𝙧𝙣 𝟰 — Subsequence with Arrays (Integers)
//    void subset(int[] arr, int idx, int sum) {
//        if (idx == arr.length) {
//            list.add(sum);
//            return;
//        }
//
//        // Include
//        subset(arr, idx + 1, sum + arr[idx]);
//
//        // Exclude
//        subset(arr, idx + 1, sum);
//    }

    //𝙋𝙖𝙩𝙩𝙚𝙧𝙣 𝟱 — Backtracking Style (In-place Modify + Undo)
//    void subseq(String s, int idx, StringBuilder ans) {
//        if (idx == s.length()) { print(ans); return; }
//
//        // include
//        ans.append(s.charAt(idx));
//        subseq(s, idx + 1, ans);
//        ans.deleteCharAt(ans.length() - 1); // backtrack
//
//        // exclude
//        subseq(s, idx + 1, ans);
//    }

    //𝙋𝙖𝙩𝙩𝙚𝙧𝙣 𝟲 — Return-based Subsequence

List<String> subsequence (String s) {
    if (s.isEmpty()) {
        List<String> list = new ArrayList<>();
        list.add("");
        return list;
    }
    char ch = s.charAt(0);
    List<String> smallAns = subsequence(s.substring(1));

    List<String> ans = new ArrayList<>();
    for (String str : smallAns) {
        ans.add(str);         // exclude
        ans.add(ch + str);    // include
    }
    return ans;

}
}
