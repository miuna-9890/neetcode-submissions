class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(temp, ans, nums, 0);
        return ans;
    }

    public void dfs(List<Integer> temp, List<List<Integer>> ans, int[] nums, int start) {

        ans.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            dfs(temp, ans, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
