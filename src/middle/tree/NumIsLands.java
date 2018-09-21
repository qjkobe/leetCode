package middle.tree;

public class NumIsLands {
    public static void main(String[] args) {
        NumIsLands a = new NumIsLands();
        char[][] grid = {{'1', '0', '1'}, {'0', '1', '0'}};
        System.out.println(a.numIslands(grid));
    }

    int m;
    int n;

    public int numIslands(char[][] grid) {
        //对每个1深度遍历。
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
