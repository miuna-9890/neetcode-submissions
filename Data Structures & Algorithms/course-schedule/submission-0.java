class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       int[] state = new int[numCourses];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        boolean ans = true;

        for (int[] req: prerequisites) {
            if (map.containsKey(req[0])) {
                ArrayList<Integer> neighbours = map.get(req[0]);
                neighbours.add(req[1]);
            } else {
                ArrayList<Integer> neighbours = new ArrayList<>();
                neighbours.add(req[1]);
                map.put(req[0], neighbours);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            ans = ans && dfs(i, state, map);
        }

        return ans;
    }

    public boolean dfs(int course, int[] path, HashMap<Integer, ArrayList<Integer>> map) {
        if (path[course] == 1) {
            return false;
        }

        if (path[course] == 2) {
            return true;
        }

        path[course] = 1;

        ArrayList<Integer> neighbours = 
        map.getOrDefault(course, new ArrayList<>());

        for (int i = 0; i < neighbours.size(); i++) {
           if (!dfs(neighbours.get(i), path, map)) {
            return false;
           }
        }

        path[course] = 2;
        return true;

    }
}
