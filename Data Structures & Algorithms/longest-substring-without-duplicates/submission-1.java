class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while(set.contains(s.charAt(i))) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(i));
            max = Math.max(max, set.size());
        }
        return max;
    }
}
