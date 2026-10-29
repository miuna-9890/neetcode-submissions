class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
                int cmax = max * nums[i];
                int cmin = min * nums[i];
                max = Math.max(nums[i], Math.max(cmax, cmin));
                min = Math.min(nums[i], Math.min(cmax, cmin));

                result = Math.max(result, max);
        }

        return result;
        
    }
}
