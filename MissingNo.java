package Arrays;

public class MissingNo {
    public int missingNumber(int[] arr, int n) {
        int total=n*(n+1)/2;
        int sum=0;
        int missing;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];

        }
        missing=total-sum;
        return missing;
    }

    public static void main(String[] args) {
        MissingNo no=new MissingNo();
        int[] arr={1,3,4,5,6};
        int n=arr.length+1;
        int result= no.missingNumber(arr,n);
        System.out.println(result);
    }
}

