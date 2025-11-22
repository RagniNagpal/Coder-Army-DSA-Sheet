package Arrays;

public class Fine {
    // User function Template for Java

    class Solution {

        public long totalFine(int date, int car[], int fine[]) {
            // code here
            int n=car.length;
            int m=fine.length;
            int sum=0;
            for(int i=0;i<m;i++){
                if(date % 2==0){
                    if(car[i] % 2!=0){
                        sum+=fine[i];
                    }

                }
                else{
                    if(car[i] % 2==0){
                        sum+=fine[i];
                    }
                }
            }
            return sum;
        }
    }
}
