package Arrays;
//
//public class CheckArray {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int m=sc.nextInt();
//        int[] arr1=new int[n];
//        int[] arr2=new int[m];
//        for(int i=0;i<n;i++){
//            arr1[i]=sc.nextInt();
//        }
//        for(int i=0;i<m;i++){
//            arr2[i]=sc.nextInt();
//        }
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//        boolean found = false;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(arr1[i]==arr2[j]){
//                    found=true;
//                    break;
//                }
//            }
//        }
//        if(found){
//            System.out.println("true");
//        }
//        else{
//            System.out.println("false");
//        }
//    }
//}


//alternative
//ye uske liye h jab hamko element serach karna h par ham equal check kar rhe h
//to approch❌
//public class CheckArray{
//    public static boolean checkEqual(int[] arr1, int[] arr2){
//        HashSet<Integer> set=new HashSet<>();
//        for(int num:arr1){
//            set.add(num);
//        }
//        for(int num:arr2){
//            if(set.contains(num)){
//                return true;
//            }
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        int[] arr1 = {4, 2, 7, 1};
//        int[] arr2 = {9, 6, 3, 7};
//
//        System.out.println(checkEqual(arr1, arr2));
//    }
//}

//frequency
//class Solution {
//    public static boolean checkEqual(int[] a, int[] b) {
//        if (a.length != b.length) return false;
//
//        HashMap<Integer, Integer> map1 = new HashMap<>();
//        HashMap<Integer, Integer> map2 = new HashMap<>();
//
//        // Count frequency for array a
//        for (int num : a) {
//            map1.put(num, map1.getOrDefault(num, 0) + 1);
//        }
//
//        // Count frequency for array b
//        for (int num : b) {
//            map2.put(num, map2.getOrDefault(num, 0) + 1);
//        }
//
//        // Compare both maps
//        return map1.equals(map2);
//    }
//}




//Answer
import java.util.Arrays;

class Solution {
    public static boolean checkEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}


