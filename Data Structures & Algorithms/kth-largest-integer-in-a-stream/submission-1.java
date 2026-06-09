class KthLargest {
    int k;

    Queue<Integer> q = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i : nums) {
            q.add(i);
            while (q.size() > k) {
                q.poll();
            }
        }
    }
    
    public int add(int val) {
        q.add(val);
        while (q.size() > k) {
            q.poll();
        }

        return q.peek();
    }
}
