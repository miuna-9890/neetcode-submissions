class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }        
        return helper(dp, m-1, n-1);
        
    }

    public int helper(int[][] dp, int i, int j) {
        if (i < 0 ||  j < 0 ) {
            return 0;
        }

        // Starting point
        if (i == 0 && j == 0) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int top = helper(dp, i-1, j);
        int left = helper(dp, i, j-1);
        dp[i][j] = top + left;

        

        return dp[i][j];
    }
}
