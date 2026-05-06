class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int upperBound = findMax(piles);
        int left = 1;
        int right = upperBound;
        int finalK = upperBound;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currTime = compute(mid, piles);

            if (currTime > h) {
                left = mid + 1;
            } else {
                    finalK = Math.min(finalK, mid);
                    right = mid - 1;
                }
            
        }
        return finalK;
    }

    public int compute(int k, int[] piles) {
        int sum = 0;
        for (int p: piles) {
            sum += Math.ceil((double)p/k);
        }
        return sum;
    }

    public int findMax(int[] piles) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(max, n);
        }
        return max;
    }
}
