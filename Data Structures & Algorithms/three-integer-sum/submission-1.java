class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int target = 0 - x;
            if (i > 0 && x == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    triplets.add(Arrays.asList(x, nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }

                    while (right > left && nums[right] == nums[right+ 1]) {
                        right--;
                    }
                }

                  if (nums[left] + nums[right] > target) {
                    right--;
                  }

                  if (nums[left] + nums[right] < target) {
                    left++;
                  }
            }
        }
            return triplets;

        
    }
}
