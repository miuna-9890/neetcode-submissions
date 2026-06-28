class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        boolean[] chosen = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, temp, ans, chosen);
        return ans;
    }

    public void dfs(int[] nums, List<Integer> temp, List<List<Integer>> ans, boolean[] chosen) {

        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (chosen[i]) {
                continue;
            }
            temp.add(nums[i]);
            chosen[i] = true;
            dfs(nums, temp, ans, chosen);
            chosen[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
