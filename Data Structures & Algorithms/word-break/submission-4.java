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

            if (s.startsWith(word)) {
                String remaining = s.substring(word.length());
                Boolean ans = helper(remaining, wordDict, map);
                if (ans) {
                    map.put(s, true);
                    return true;
                } 
            }
        }
                map.put(s, false);

        return false;
    }
}
