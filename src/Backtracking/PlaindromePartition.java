package Backtracking;

public class PlaindromePartition {
}
//
//class Solution {
//    public List<List<String>> partition(String s) {
//        List<List<String>> result = new ArrayList<>();
//        backtrack(0, s, new ArrayList<>(), result);
//        return result;
//    }
//
//    private void backtrack(int index, String s, List<String> path, List<List<String>> result) {
//        if (index == s.length()) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = index; i < s.length(); i++) {
//            if (isPalindrome(s, index, i)) {
//                path.add(s.substring(index, i + 1));  // choose
//                backtrack(i + 1, s, path, result);     // explore
//                path.remove(path.size() - 1);          // backtrack
//            }
//        }
//    }
//
//    private boolean isPalindrome(String s, int l, int r) {
//        while (l < r) {
//            if (s.charAt(l++) != s.charAt(r--)) return false;
//        }
//        return true;
//    }
//}
