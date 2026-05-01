class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                char opening = map.get(c);
                if (stack.isEmpty() || stack.pop() != opening) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        } 

        return stack.isEmpty();
        
    }
}
