class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]-1)) {
                continue;
            } else {
                int curr = 0;
                int val = nums[i];
                while(set.contains(val++)) {
                    curr+=1;
                }
                max = Math.max(max, curr);
            }
            
        }
        return max;
        
    }
}
