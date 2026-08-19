class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            ArrayList<Integer> req = new ArrayList<>();
            map.put(i, req);
        }

        for (int[] course: prerequisites) {
            map.get(course[1]).add(course[0]);
            indegrees[course[0]] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }
        int resultIndex = 0;

        while(!q.isEmpty()) {
            int curr = q.poll();
            result[resultIndex] = curr;
            resultIndex++;

            ArrayList<Integer> req = map.get(curr);

            for (int i = 0; i < req.size(); i++) {
                indegrees[req.get(i)] -= 1;

                if (indegrees[req.get(i)] == 0) {
                    q.offer(req.get(i));
                }
            }
        }

        if (resultIndex == numCourses) {
            return result;
        } else {
            return new int[0];
        }
        
    }
}
