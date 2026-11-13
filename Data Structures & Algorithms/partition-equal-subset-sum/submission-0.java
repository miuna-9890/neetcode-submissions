class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, 0, nums, target, dp);
        
    }

    public boolean helper(int i, int currSum, int[] nums, int target, int[][] dp) {
        if (currSum == target) {
            return true;
        }

        if (i == nums.length || currSum > target) {
            return false;
        }

        if (dp[i][currSum] != -1) {
            return dp[i][currSum] == 1;
        }

        boolean include = helper(
            i + 1, currSum + nums[i], nums, target, dp
        );

        boolean exclude = helper(
            i + 1, currSum, nums, target, dp
        );

        dp[i][currSum]  = include || exclude ? 1 : 0;

        return dp[i][currSum] == 1;

    }

}
