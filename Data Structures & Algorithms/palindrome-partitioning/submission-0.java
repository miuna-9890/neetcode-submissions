class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(s, temp, ans, 0);
        return ans;
    }

    public void dfs(String s, List<String> temp, List<List<String>> ans, int start) {

        if (start >= s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                String part = s.substring(start, end + 1);
                temp.add(part);
                dfs(s, temp, ans, end + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
