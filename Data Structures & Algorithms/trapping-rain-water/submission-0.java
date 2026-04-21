class Solution {
    public int trap(int[] height) {
        int maxL = 0;
        int maxR = 0;
        int left = 0;
        int right = height.length - 1;
        int sum = 0;

        while (left <= right) {
            if (height[left] <= height[right]){
                if(height[left] < maxL) {
                    sum += maxL - height[left];
                } else {
                    maxL = height[left];
                }
                left++;
            } else {
                if(height[right] < maxR) {
                    sum += maxR - height[right];
                } else {
                    maxR = height[right];
                }
                right--;
            }

        }
        return sum;
    }
}
