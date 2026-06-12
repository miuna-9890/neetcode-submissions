class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Task> maxHeap = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            maxHeap.add(new Task(entry.getKey(), entry.getValue()));
        }

        int time = 0;
        Queue<Task> coolDown = new LinkedList<>();

        while(!maxHeap.isEmpty() || !coolDown.isEmpty()) {
            time++;

            int size = coolDown.size();

            for (int i = 0; i < size; i++) {
                Task t = coolDown.poll();

                if (t.availableTime < time) {
                    maxHeap.add(t);
                } else {
                    coolDown.add(t);
                }
            }

            if (!maxHeap.isEmpty()) {
                Task curr = maxHeap.poll();
                curr.freq--;
                if (curr.freq > 0) {
                    curr.availableTime = time + n ;
                    coolDown.add(curr);
                }
            }
        }

        return time;


    }
}

class Task {
    char task;
    int freq;
    int availableTime;

    Task(char task, int freq) {
        this.task = task;
        this.freq = freq;
        this.availableTime = 0;
    }
}
