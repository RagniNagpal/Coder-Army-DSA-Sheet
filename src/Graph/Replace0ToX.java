package Graph;

public class Replace0ToX {

    public char[][] solve(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] vis = new boolean[rows][cols];

        // Top row and Bottom row
        for (int col = 0; col < cols; col++) {
            if (grid[0][col] == 'O') dfs(grid, vis, 0, col);
            if (grid[rows - 1][col] == 'O') dfs(grid, vis, rows - 1, col);
        }

        // Left column and Right column
        for (int row = 0; row < rows; row++) {
            if (grid[row][0] == 'O') dfs(grid, vis, row, 0);
            if (grid[row][cols - 1] == 'O') dfs(grid, vis, row, cols - 1);
        }

        // Convert unvisited 'O' → 'X'
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 'O' && !vis[r][c]) {
                    grid[r][c] = 'X';
                }
            }
        }

        return grid;
    }

    // DFS
    void dfs(char[][] grid, boolean[][] vis, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols) return;
        if (vis[r][c] || grid[r][c] == 'X') return;

        vis[r][c] = true;

        dfs(grid, vis, r - 1, c); // up
        dfs(grid, vis, r + 1, c); // down
        dfs(grid, vis, r, c - 1); // left
        dfs(grid, vis, r, c + 1); // right
    }

    public static void main(String[] args) {

        Replace0ToX obj = new Replace0ToX();

        char[][] grid = {
                {'X','O','X','X'},
                {'O','O','X','X'},
                {'X','X','O','X'},
                {'O','X','O','O'}
        };

        char[][] ans = obj.solve(grid);

        // Print output
        for (char[] row : ans) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
