class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] freqA = new int[26];
        int[] freqB = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freqA[s1.charAt(i) - 'a']++;
            freqB[s2.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(freqA, freqB)) {
                return true;
            }
            freqB[s2.charAt(i + s1.length()) - 'a']++;
            freqB[s2.charAt(i) - 'a']--;
        }
        return matches(freqA, freqB);
    }

    public boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}