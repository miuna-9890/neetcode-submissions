class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        dfs(candidates, target, 0, sub, ans);
        return ans;
    }

    public void dfs(int[] candidates, int target, int i, List<Integer> sub, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(sub));
            return;
        }

        if (target < 0 || i >= candidates.length) {
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            sub.add(candidates[j]);
            dfs(candidates, target - candidates[j], j + 1, sub, ans);
            sub.remove(sub.size() - 1);
        }
    }
}
