class Solution {
    List<String> operators = Arrays.asList("+", "-", "*", "/");
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {
            if (isOperator(t)) {
                int b = stack.pop();
                int a = stack.pop();
                switch (t) {
            case "+":
                stack.push(a + b);
                break;
            case "-":
                stack.push(a-b);
                break;
            case "*":
                stack.push(a*b);
                break;
            case "/":
                stack.push(a/b);
                break;
                }
            } else {
                stack.push(Integer.parseInt(t));
            }
    }
    return stack.pop();
    }

    public boolean isOperator(String t) {
        if (operators.contains(t)) {
            return true;
        } 
        return false;
    }
    }
