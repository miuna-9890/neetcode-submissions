class Solution {
    public boolean isAnagram(String s, String t) {

        // Hashmap
        // iterate through s, store (character, count)
        // iterate through t, retreive value of key -> character
        // minus count

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (!map.containsKey(curr)) {
                return false;
            }
            map.put(curr, map.get(curr) - 1);
        }

        for (int freq: map.values()) {
            if (freq != 0) {
                return false;
            }
        }

        return true;
    }
}
