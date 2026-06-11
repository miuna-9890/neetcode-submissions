class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> b[2] - a[2]);
        int x1 = 0;
        int y1 = 0;

        for(int[] point: points) {
            int x2 = point[0];
            int y2 = point[1];
            int distance = x2 * x2 + y2 * y2;
            pq.add(new int[]{x2, y2, distance});
            while (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            ans[i][0] = curr[0];
            ans[i][1] = curr[1];
            i++;
        }

        return ans;

    }
}
