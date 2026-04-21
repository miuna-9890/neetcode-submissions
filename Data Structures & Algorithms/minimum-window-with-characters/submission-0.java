    class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> map = new HashMap<>();
            HashMap<Character, Integer> map2 = new HashMap<>();
            int left = 0;
            int cnt = 0;
            int minLeft = 0;
            int minLen = s.length() + 1;
            for (int i = 0 ; i < t.length(); i ++) {
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            }

            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    map2.put(c, map2.getOrDefault(c, 0) + 1);
                    if (map2.get(c).intValue() == map.get(c).intValue()) {
                        cnt++;
                    }
                }

                while (cnt == map.size()) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minLeft = left;
                    }
                    char c1 = s.charAt(left);
                    if (map.containsKey(c1)) {
                        if (map2.get(c1).intValue() == map.get(c1).intValue()) {
                            cnt--;
                        }
                        map2.put(c1, map2.getOrDefault(c1, 0) - 1);
                    }
                    left++;
                }
            }
            return minLen == s.length() + 1 ? "" : s.substring(minLeft, minLeft + minLen);
        }
    }
