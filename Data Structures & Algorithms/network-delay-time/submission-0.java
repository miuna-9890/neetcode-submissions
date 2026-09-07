class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
    graph[i] = new ArrayList<>();
}
        for (int[] edge: times) {
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];

            graph[u].add(new int[]{v,t});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if (time > dist[node]) {
                continue;
            }

            for (int[] edge: graph[node]){
                int next = edge[0];
                int nextTime = edge[1];
                int newTime = nextTime + time;

                if (newTime < dist[next]) {
                    dist[next] = newTime;
                    pq.offer(new int[]{next, newTime});
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}
