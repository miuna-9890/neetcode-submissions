class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int med = (nums1.length + nums2.length + 1) / 2;

        int l = 0;
        int r = nums1.length;
        int x = 0;

        while (l <= r) {
            x = (l + r) / 2;

            int leftA = x == 0 ? Integer.MIN_VALUE : nums1[x - 1];
            int rightA = x == nums1.length ? Integer.MAX_VALUE : nums1[x];
            int leftB = med - x == 0 ? Integer.MIN_VALUE : nums2[med - x - 1];
            int rightB = med - x == nums2.length ? Integer.MAX_VALUE : nums2[med - x];

            
            if (leftA > rightB) {
                r = x - 1;
            } else if (leftB > rightA) {
                l = x + 1;
            } else {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                } else {
                    return Math.max(leftA, leftB);
                }
            }
        }

       return -1;
    }
}
