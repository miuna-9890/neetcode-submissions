class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }


        int left = 0;
        for (int i = k; i <= nums.length; i++) {
            ans[left] = map.lastKey();

            if (i == nums.length) {
                break;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
            if (map.get(nums[left]) == 0) {
                map.remove(nums[left]);
            }
            left++;
        }

        return ans;
        
    }
}
