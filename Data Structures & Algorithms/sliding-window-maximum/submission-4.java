class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0;
        int r = 0;
        
        while (r < nums.length) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            if (l > q.getFirst()) {
                q.removeFirst();
            }

            if (r + 1 >= k) {
                ans[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return ans;
    }
}
