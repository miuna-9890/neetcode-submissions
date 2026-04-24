class Solution {
    public int longestConsecutive(int[] nums) {
        // Treeset, ascending order
        //iterate once through array -> O(n) 
        // add elements to treeset

        // initialize max count
        // iterate through treeset, 
        // keep track of curr count, add to count if curr elem - prev elem = 1
        // update max count
        // else restart curr count

        if (nums.length == 1) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i]-1)) {
                int currCount = 1;
                int curr = nums[i];

                while (set.contains(curr + 1)) {
                    currCount += 1;
                    curr+= 1;
                }
                maxLength = Math.max(maxLength, currCount);
            }
        }
        return maxLength;
    }
}
