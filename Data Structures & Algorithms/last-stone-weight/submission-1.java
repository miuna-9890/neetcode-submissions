class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        for (int n: stones) {
            q.add(n);
        }
        while (q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            if ( a != b) {
                q.add(a-b);
            }
        }

        if (q.size() == 1) {
            return q.poll();
        } else {
            return 0;
        }
    }
}
