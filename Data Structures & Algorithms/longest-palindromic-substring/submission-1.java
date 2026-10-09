class Solution {
    public String longestPalindrome(String s) {
        int reslen = 0;
        int start = 0;
    for (int i = 0; i < s.length(); i++) {
        int currOdd = find(s, i, i);
        int currEven = find(s, i, i+1);
        int curr = Math.max(currOdd, currEven);

        if ((curr) > reslen) {
            reslen = curr;
            start = i - ((curr-1) / 2);
        };
    }

    return s.substring(start, start + reslen);
        
    }
    
public int find(String s, int l, int r) {
   while (l >= 0 && r < s.length()
        && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
}


    return r-l-1;
}
}
