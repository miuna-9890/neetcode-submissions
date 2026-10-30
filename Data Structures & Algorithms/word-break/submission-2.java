class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> map = new HashMap<>();
        return helper(s, wordDict, map);
    }

    public boolean helper(String s, List<String> wordDict, HashMap<String, Boolean> map) {
        if (s.length() == 0) {
            return true;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (String word: wordDict) {
            int len = word.length();
            int i = 0;
            if (s.startsWith(word)) {
                String remaining = s.substring(word.length());
                Boolean ans = helper(remaining, wordDict, map);
                if (ans) {
                    map.put(remaining, ans);
                    return true;
                } else {
                 map.put(remaining, ans);

                }
            }
        }

        return false;
    }
}
