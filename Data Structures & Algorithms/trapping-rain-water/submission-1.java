class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int maxR = 0;
        int maxL = 0;

        while (left < right) {

            maxR = Math.max(height[right], maxR);
            maxL = Math.max(height[left], maxL);

            if (height[left] <= height[right]) {
                if (height[left] <= Math.min(maxR, maxL)) {
                max += Math.min(maxR, maxL) - height[left];
                }
                left++;
            }
            if (height[left] > height[right]) {
                 if (height[right] <= Math.min(maxR, maxL)) {
                max += Math.min(maxR, maxL) - height[right];
                 }
                right--;
            }
        }

        return max;
        
    }
}
