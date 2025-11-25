package DP;

public class RodCutting {
    public static int RodCutting(int[] price, int N) {
        int[] length = new int[N];
        for (int i = 0; i < N; i++) length[i] = i + 1;

        int[][] t = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                if (length[i - 1] <= j) {
                    // Unbounded: can take same i again
                    t[i][j] = Math.max(
                            price[i - 1] + t[i][j - length[i - 1]],
                            t[i - 1][j]
                    );
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[N][N];
    }
    public static void main(String[] args) {

    }
}

//Type	Complexity
//Time	O(N²)
//Space	O(N²)
