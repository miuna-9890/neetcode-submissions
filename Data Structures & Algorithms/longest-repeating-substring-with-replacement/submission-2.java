class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int max = 0;
        int maxOccurence = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxOccurence = Math.max(maxOccurence, freq[s.charAt(right) - 'A']);

            if (right - left + 1 - maxOccurence > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            } else {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
        
    }
}
