class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        
        int open = 0;
        int close = 0;

        dfs(n, ans, new StringBuilder(), open, close);
        return ans;
    }

    public void dfs(int n, List<String> ans, StringBuilder temp, int open, int close) {
        
        if (temp.length() == 2*n) {
            ans.add(temp.toString());
        }

        if (open < n) {
            temp.append("(");
            dfs(n, ans, temp, open + 1, close);
            temp.deleteCharAt(temp.length() - 1);
        }

        if (close < open) {
            temp.append(")");
            dfs(n, ans, temp, open, close + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
