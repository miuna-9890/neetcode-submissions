class Solution {
    public boolean hasDuplicate(int[] nums) {

        // Hashset
        // Iterate through the loop, for every element if it exist in the hashset
        // then u return false, cause it is a duplicate, if no u add it into the hashset
        // at the end of the loop, return false 

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}