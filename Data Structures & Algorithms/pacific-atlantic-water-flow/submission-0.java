class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < cols; i++) {
            dfs(0, i, pacific, heights[0][i], heights);
            dfs(rows - 1, i, atlantic, heights[rows-1][i], heights);
        }

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pacific, heights[i][0], heights);
            dfs(i, cols - 1, atlantic, heights[i][cols-1], heights);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
        

    }

    public void dfs(int r, int c, boolean[][] ocean, int h, int[][] heights) {
        if (r < 0 || r >= ocean.length || c < 0 || c >= ocean[0].length) {
            return;
        }

        if (ocean[r][c]) {
            return;
        }

        int curr = heights[r][c];
        if (curr < h) {
            return;
        }
        ocean[r][c] = true;
        

        dfs(r + 1, c, ocean, curr, heights);
        dfs(r - 1, c, ocean, curr, heights);
        dfs(r, c + 1, ocean, curr, heights);
        dfs(r, c - 1, ocean, curr, heights);
    }
}
