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

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.count - a.count);
        int[] result = new int[k];
        for (int key : map.keySet()) {
            pq.add(new Pair(key, map.get(key)));
        }

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().num;
        }
        return result;
    }

    class Pair {
        int num;
        int count;

        Pair(int num, int count) {
            this.num = num;
            this.count = count;
        } 
    }
}
