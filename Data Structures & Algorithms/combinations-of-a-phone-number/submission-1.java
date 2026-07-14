class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        dfs(digits, ans, new StringBuilder(), 0, map);
        return ans;
    }

    public void dfs(String digits, List<String> ans, StringBuilder temp, int i, HashMap<Character, String> map) {
        
        if (i >= digits.length()) {
            ans.add(temp.toString());
            return;
        }

        String letters = map.get(digits.charAt(i));
        for (int start = 0; start < letters.length(); start++) {
            temp.append(letters.charAt(start));
            dfs(digits, ans, temp, i + 1, map);
            temp.deleteCharAt(temp.length() - 1);
        }
    }


}
