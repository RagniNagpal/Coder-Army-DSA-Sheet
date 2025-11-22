package Graph;

public class NoOfIslands {
    class Solution {
        public int numIslands(char[][] grid) {

            int rows = grid.length;
            int cols = grid[0].length;

            int count = 0;

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {

                    if (grid[r][c] == '1') {
                        count++;            // found a new island
                        dfs(grid, r, c);    // mark whole island as 0
                    }

                }
            }
            return count;
        }

        private void dfs(char[][] grid, int r, int c) {

            // boundary check
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
                return;

            // stop if water OR already visited
            if (grid[r][c] == '0')
                return;

            // mark current land as visited (sink island)
            grid[r][c] = '0';

            // explore all 4 directions
            dfs(grid, r - 1, c); // up
            dfs(grid, r + 1, c); // down
            dfs(grid, r, c - 1); // left
            dfs(grid, r, c + 1); // right
        }
    }

}
//Time: O(R × C)
//
//Space: O(R × C)