class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Hashmap (num, count)
        // iterate through the array, if nums[i] exists, map.get(nums[i])+1
        // else, u map.put(nums[i], 1)

        // input the hashmap into priortity queue the output top k elements

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[] result = new int[k];
        for (int key : map.keySet()) {
            pq.offer(new int[]{map.get(key), key});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[1];
        }
        return result;
    }
}
