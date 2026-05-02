class Solution {
    public int evalRPN(String[] tokens) {
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("/");
        set.add("*");

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (set.contains(tokens[i])) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int result = compute(a, b, tokens[i]);
                stack.push(String.valueOf(result));
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public int compute(int a, int b, String operand) {
        int result = 0;
        
        if (operand.equals("+")) {
            result = a + b;
        } else if (operand.equals("-")) {
             result = a - b;
        } else if (operand.equals("*")) {
             result = a * b;
        } else {
             result = a / b;
        }
        return result;
    }
}
