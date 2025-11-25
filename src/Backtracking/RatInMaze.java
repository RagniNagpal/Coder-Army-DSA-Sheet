package Backtracking;

public class RatInMaze {

//    public static void main(String[] args) {
//        int rows = 3;
//        int cols = 3;
//
//        System.out.println("All paths from top-left to bottom-right:");
//        printPaths(1, 1, rows, cols, "");
//
//        int totalPaths = countPaths(1, 1, rows, cols);
//        System.out.println("\nTotal number of paths: " + totalPaths);
//
//        //backtracking rec(4 paths)
////        int rows1=3;
////        int cols1=3;
////        print(1,1,rows1,cols1,"");
//    }
//
//    // ----------------------------
//    // ✅ Method 1: Print all paths
//    // ----------------------------
//    // sr, sc -> current row and column
//    // er, ec -> ending row and column
//    // path -> stores moves so far ('R' for right, 'D' for down)
//    private static void printPaths(int sr, int sc, int er, int ec, String path) {
//        // Out of bounds
//        if (sr > er || sc > ec) return;
//
//        // Reached destination
//        if (sr == er && sc == ec) {
//            System.out.println(path);
//            return;
//        }
//
//        // Move down
//        printPaths(sr + 1, sc, er, ec, path + 'D');
//
//        // Move right
//        printPaths(sr, sc + 1, er, ec, path + 'R');
//    }
//
//    // ----------------------------
//    // ✅ Method 2: Count total paths
//    // ----------------------------
//    private static int countPaths(int sr, int sc, int er, int ec) {
//        // Out of bounds
//        if (sr > er || sc > ec) return 0;
//
//        // Reached destination
//        if (sr == er && sc == ec) return 1;
//
//        // Count paths by moving down
//        int down = countPaths(sr + 1, sc, er, ec);
//
//        // Count paths by moving right
//        int right = countPaths(sr, sc + 1, er, ec);
//
//        // Total paths from current cell
//        int total = down + right;
//
//        return total;
//    }
//
//    //Not possible
//    //backtracking rec(4 path)(agra ye ham run karenge to infinite loop agar ham ek path par aagye isse ham dobara baar baar usi path mei aa jaenge )
////    private static void print(int sr, int sc, int er, int ec, String path) {
////        if(sr < 1 || sc< 1) return;
////        // Out of bounds
////        if (sr > er || sc > ec) return;
////
////        // Reached destination
////        if (sr == er && sc == ec) {
////            System.out.println(path);
////            return;
////        }
////
////        // Move down
////        print(sr + 1, sc, er, ec, path + 'D');
////
////        // Move right
////        print(sr, sc + 1, er, ec, path + 'R');
////
////        //Move left
////        print(sr, sc - 1, er, ec, path + 'L');
////
////        //Move up
////        print(sr, sc - 1, er, ec, path + 'U');
////
////
////    }


    //original backtracking code

        public static void main(String[] args) {
            int rows = 3;
            int cols = 3;
            boolean[][] isVisited = new boolean[rows][cols];
            print(0, 0, rows - 1, cols - 1, "", isVisited);
        }

        private static void print(int sr, int sc, int er, int ec, String path, boolean[][] isVisited) {
            // Boundary check
            if (sr < 0 || sc < 0 || sr > er || sc > ec) return;

            // Already visited
            if (isVisited[sr][sc]) return;

            // Reached destination
            if (sr == er && sc == ec) {
                System.out.println(path);
                return;
            }

            // Mark as visited
            isVisited[sr][sc] = true;

            // Move in all 4 directions
            print(sr + 1, sc, er, ec, path + 'D', isVisited); // Down
            print(sr, sc + 1, er, ec, path + 'R', isVisited); // Right
            print(sr, sc - 1, er, ec, path + 'L', isVisited); // Left
            print(sr - 1, sc, er, ec, path + 'U', isVisited); // Up

            // Backtrack: unmark visited
            isVisited[sr][sc] = false;    //imp
        }


}
