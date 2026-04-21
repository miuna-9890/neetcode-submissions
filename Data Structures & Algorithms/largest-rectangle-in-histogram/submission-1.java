class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int idx = stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, heights[idx] * w);
            }
            stack.push(i);
        }
        return max;
    }
}
