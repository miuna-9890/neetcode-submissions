class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int count = 0;

        for (int[] e: edges) {
            if (!map.containsKey(e[0])) {
                map.put(e[0], new ArrayList<>());
            }
            if (!map.containsKey(e[1])) {
                map.put(e[1], new ArrayList<>());
            }
            map.get(e[1]).add(e[0]);
            map.get(e[0]).add(e[1]);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i, map, visited);
            count++;
        }

        return count;
    }

    public void dfs(int i, HashMap<Integer, ArrayList<Integer>> map, boolean[] visited) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;

        ArrayList<Integer> neigh = map.getOrDefault(i, new ArrayList<>());

        for (int j = 0; j < neigh.size(); j++) {
            dfs(neigh.get(j), map, visited);
        }
    }
}
