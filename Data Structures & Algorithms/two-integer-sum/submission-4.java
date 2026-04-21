class Solution {
    public int[] twoSum(int[] nums, int target) {

        // target = 7
        // hashmap -> nums[i], i
        // itrate through the array, i for every nums[i] if target - nums[i]
        // exists in hashmap, return val, i

        //two pointer
        // iterate from left and right
        // add the 2 values nums[left] & nums[right]
        // if sum > target, right --
        // if sum < target, left ++
        // if sum = target, left, rigth

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val) && map.get(val) != i) {
                return new int[]{map.get(val), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
