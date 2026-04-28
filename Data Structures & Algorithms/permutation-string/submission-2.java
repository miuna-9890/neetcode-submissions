class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq = new int[26];
        for (char c: s1.toCharArray()) {
            freq[c - 'a'] += 1;
        }

        //create map for first feq elements
        int[] subfreq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            subfreq[s2.charAt(i) - 'a'] += 1;
        }

        if (Arrays.equals(freq, subfreq)) {
                return true;
            }

            int left = 0;
            for (int right = s1.length(); right < s2.length(); right++) {
                subfreq[s2.charAt(left) - 'a'] -= 1;
                left++;

                subfreq[s2.charAt(right) - 'a'] += 1;

                if (Arrays.equals(freq, subfreq)) {
                return true;
            }
            
            }

        return false;
        }
    }
