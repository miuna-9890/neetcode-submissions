class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int left = 0;
        int min = s.length();
        String result = "";
        

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }       

        int formed = 0;
        int required = map.size();

        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);

            if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) 
                == sMap.get(s.charAt(right))) {
                    formed++;
                }

            while (required == formed) {
                if (right - left + 1 <= min) {
                    min = right - left + 1;
                    result = s.substring(left , right + 1);
                }

                sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left), 0) - 1);
                if (map.containsKey(s.charAt(left)) && map.get(s.charAt(left)) 
                > sMap.get(s.charAt(left))) {
                    formed--;
                }

                left++;
            }

        }

        return result;
    }
}
