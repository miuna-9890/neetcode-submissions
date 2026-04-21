class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int ans = 0;
        int max = 0;

        for (right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            max = Math.max(max, freq[s.charAt(right) - 'A']);
            while (right - left + 1 - max > k && left < s.length()) {
                freq[s.charAt(left) - 'A']--;
                left++; 
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
