class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) {
            return false;
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        boolean ans = true;

        for (int[] node: edges) {
            if (!map.containsKey(node[0])) {
                map.put(node[0], new ArrayList<>());
            }
            if (!map.containsKey(node[1])) {
                map.put(node[1], new ArrayList<>());
            }
            map.get(node[0]).add(node[1]);
            map.get(node[1]).add(node[0]);
        }

        
        ans = ans && dfs(0, map, visited, n, -1);
        if (visited.size() != n) {
            return false;
        }
        
        return ans;
    }

    public boolean dfs(int node, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> visited, int n, int parent) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        ArrayList<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());

        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i) == parent) {
                continue;
            }
           if (!dfs(neighbours.get(i), map, visited, n, node)) {
            return false;
           }
        }
        return true;
    }
}
