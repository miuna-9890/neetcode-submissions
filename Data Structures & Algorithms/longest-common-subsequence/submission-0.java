class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }


        return helper(dp, 0, 0, text1, text2);

    }

    public int helper(int[][] dp, int i, int j, String a, String b) {
        if (i < 0 || i >= a.length() || j < 0 || j >= b.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (a.charAt(i) == b.charAt(j)) {
            dp[i][j] = 1 + helper(dp, i + 1, j + 1, a, b);
        } else {
            dp[i][j] = Math.max(
                helper(dp, i + 1, j, a, b),helper(dp, i, j + 1, a, b)) ;
        }

        return dp[i][j];
    }
}
