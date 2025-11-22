package Graph;
import java.util.*;

public class CovidSpread {
    public int helpaterp(int[][] hospital){
        int R=hospital.length;
        int C=hospital[0].length;

        Queue<int[]> q=new LinkedList<>();
        int uninfected=0;
        for(int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                if(hospital[i][j]==2){
                    q.offer(new int[] {i,j,0});
                }else if(hospital[i][j]==1){
                    uninfected++;
                }
            }
        }
        if(uninfected==0) return 0;
        int maxTime=0;
        while(!q.isEmpty()){
            int[] curr=q.peek();
            int r=curr[0];
            int c=curr[1];
            int t=curr[2];

            q.poll();
            // TOP
            if (r - 1 >= 0 && hospital[r - 1][c] == 1) {
                hospital[r - 1][c] = 2;
                uninfected--;
                q.offer(new int[]{r - 1, c, t + 1});
                maxTime = Math.max(maxTime, t + 1);
            }

            // BOTTOM
            if (r + 1 < R && hospital[r + 1][c] == 1) {
                hospital[r + 1][c] = 2;
                uninfected--;
                q.offer(new int[]{r + 1, c, t + 1});
                maxTime = Math.max(maxTime, t + 1);
            }

            // LEFT
            if (c - 1 >= 0 && hospital[r][c - 1] == 1) {
                hospital[r][c - 1] = 2;
                uninfected--;
                q.offer(new int[]{r, c - 1, t + 1});
                maxTime = Math.max(maxTime, t + 1);
            }

            // RIGHT
            if (c + 1 < C && hospital[r][c + 1] == 1) {
                hospital[r][c + 1] = 2;
                uninfected--;
                q.offer(new int[]{r, c + 1, t + 1});
                maxTime = Math.max(maxTime, t + 1);
            }
        }

        // some uninfected left → impossible
        if (uninfected > 0) return -1;

        return maxTime;
        }

    public static void main(String[] args) {

    }
}
//📌 Final:
//
//TC: O(R × C)
//
//SC: O(R × C)