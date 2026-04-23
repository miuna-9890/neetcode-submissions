class Solution {
    public int[] productExceptSelf(int[] nums) {

        //brute force
        // iterate through array
        // inner loop (multiple other elements except curr element)
        // On^2, O(n)

        // suffix and prefix
        // prefix = 1
        // iterate through array,
        // element in result array = prefix
        // prefix *= curr element in nums

        // suffix = 1;
        // elem in result array *= suffix
        // suffix *= nums

        int[] result = new int[nums.length];

        int pre = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = pre;
            pre *= nums[i];
        }

        int suf = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suf;
            suf *= nums[i];
        }
        return result;
    }
}  
