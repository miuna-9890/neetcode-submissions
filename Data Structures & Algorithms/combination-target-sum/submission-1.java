class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        dfs(nums, target, 0, sub, ans);
        return ans;
    }

    public void dfs(int[] nums, int target, int start, List<Integer> sub, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(sub));
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
        sub.add(nums[i]);
        dfs(nums, target - nums[i], i, sub, ans);
        sub.remove(sub.size() - 1);
        }
    }
}
