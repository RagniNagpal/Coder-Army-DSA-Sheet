package Backtracking;

//jahan 0 vahan travel nhi kar sakte hai
public class RatInDeadMaze {
//    public static void main(String[] args) {
//        int rows=4;
//        int cols=6;
//        int[][] maze={{1,0,1,1,1,1,1},
//                {1,1,1,1,0,1},
//                {0,1,1,1,1,1},
//                {0,0,1,0,1,1}};
//        print(0,0,rows-1,cols-1,"",maze);
//    }
//    private static void print(int sr, int sc, int er, int ec, String s, int[][] maze){
//        if(sr > er || sc>ec) return;
//        if(sr==er && sc==ec){
//            System.out.println(s);
//            return;
//        }
//        if(maze[sr][sc]==0) return;
//        //go right
//        print(sr,sc+1,er,ec,s+'R',maze);
//        //go down
//        print(sr+1,sc,er,ec,s+'D',maze);
//    }


        public static void main(String[] args) {
            int rows=3;
        int cols=4;
            int[][] maze = {
                    {1, 0, 1, 1},
                    {1, 1, 1, 1},
                    { 1, 1,0, 1},
            };

            boolean[][] visited = new boolean[rows][cols];
            print(0, 0, rows - 1, cols - 1, "", maze);
        }

        private static void print(int sr, int sc, int er, int ec, String path, int[][] maze) {
            // base cases
            if (sr < 0 || sc < 0 || sr > er || sc > ec) return; // out of bounds
            if (maze[sr][sc] == 0) return; // blocked cell

            if (sr == er && sc == ec) {    // destination reached
                System.out.println(path);
                return;
            }

            if(maze[sr][sc]==0) return;
            if(maze[sr][sc]==-1) return;
            maze[sr][sc] = -1;

            // explore all 4 directions
            print(sr + 1, sc, er, ec, path + 'D', maze); // Down
            print(sr - 1, sc, er, ec, path + 'U', maze); // Up
            print(sr, sc + 1, er, ec, path + 'R', maze); // Right
            print(sr, sc - 1, er, ec, path + 'L', maze); // Left

            // unmark (backtrack)
            maze[sr][sc] = 1;
        }
    }


