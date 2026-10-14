class Solution {
    public int countSubstrings(String s) {
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            num += find(s, i, i);
            num += find(s, i, i +1);
        }
        return num;
    }

    public int find(String s, int l, int r) {
        int ans = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                ans++;

                l--;
                r++;
            } else {
                break;
            }
        }
        return ans;
    }
}
