class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max= 0;

        for (int i = 0; i < heights.length; i++) {
            int curr = heights[i];
            int idx = i;
            int height = 0;
            while (!stack.isEmpty() && curr < stack.peek()[1]) {
                int[] top = stack.pop();
                idx = top[0];
                height = top[1];
                max = Math.max(max, (i - idx) * height);
            }
            stack.push(new int[]{idx, heights[i]});
        }

         while (!stack.isEmpty()) {
                int[] top = stack.pop();
                int idx = top[0];
                int height = top[1];
                max = Math.max(max, (heights.length - idx) * height);
            }
        return max;
    }
}
