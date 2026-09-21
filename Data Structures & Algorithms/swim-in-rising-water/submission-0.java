//Cost of a path = maximum elevation encountered on that path.
class Solution {
    public int swimInWater(int[][] grid) {
    int n = grid.length;

    int[][] dist = new int[n][n];

    // initialize dist to infinity
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            dist[i][j] = Integer.MAX_VALUE;
        }
    }

    // min heap
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

    // starting cell
    minHeap.offer(new int[]{grid[0][0], 0, 0});
    dist[0][0] = grid[0][0];

    int[][] directions = {
        {-1,0},
        {1,0},
        {0,-1},
        {0,1}
    };

    while (!minHeap.isEmpty(    )) {

        // take smallest cost from heap
        int[] curr = minHeap.poll();

        // if destination, return cost
        if (curr[1] == n-1 && curr[2] == n-1) {
            return curr[0];
        }

        // explore 4 neighbours
        for (int[] dir: directions) {
            int nr = curr[1] + dir[0];
            int nc = curr[2] + dir[1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                int newCost = Math.max(curr[0], grid[nr][nc]);
                if (newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    minHeap.offer(new int[]{newCost, nr, nc});
                }
            
            }
        }

        // calculate newCost

        // update dist + heap if better
    }

    return -1;
}
}
