class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = max(piles);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(mid, piles, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canFinish(int speed, int[] piles, int h) {
        int count = 0;
        for (int p: piles) {
            count += (int) Math.ceil((double)p / speed);
        }
        return count <= h;
    }
    public int max(int[] piles) {
        int m = 0;
        for (int p: piles) {
            m = Math.max(m, p);
        }
        return m;
    }
}
