class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int target = (nums1.length + nums2.length + 1) / 2;
        int start = 0;
        int end = nums1.length;

        while (start <= end) {
            int p1 = (start + end ) / 2;
            int p2 = target - p1;
            int mL1 = (p1 == 0 ? Integer.MIN_VALUE: nums1[p1 - 1]);
            int mR1 = (p1 == nums1.length? Integer.MAX_VALUE: nums1[p1]);
            int mL2 = (p2 == 0? Integer.MIN_VALUE: nums2[p2 - 1]);
            int mR2 = (p2 == nums2.length? Integer.MAX_VALUE: nums2[p2]);
        
        if (mL1 <= mR2 && mL2 <= mR1) {
            if ((nums1.length + nums2.length) % 2 == 1) {
                return Math.max(mL1, mL2);
            } else {
                return ((double)(Math.max(mL1, mL2) + Math.min(mR1, mR2)) / 2);
            }
        } else if (mL1 > mR2) {
            end = p1 - 1;
        } else {
            start = p1 + 1;
        }
        }
        return 0.0;
    
    }
}
