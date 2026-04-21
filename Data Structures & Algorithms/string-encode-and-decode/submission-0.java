class Solution {

    public String encode(List<String> strs) {
        if (strs.size() == 0 ) {
            return Character.toString((char)(258));
        }
        String seperator = Character.toString((char)(257));
        StringBuilder s = new StringBuilder();
        for (String str: strs) {
            s.append(str);
            s.append(seperator);
        }
        s.deleteCharAt(s.length()-1);
        return s.toString();
    }

    public List<String> decode(String str) {
        if (str.equals(Character.toString((char)(258)))) {
            return new ArrayList<>();
        }
        String seperator = Character.toString((char)(257));
        return Arrays.asList(str.split(seperator, -1));

    }
}
