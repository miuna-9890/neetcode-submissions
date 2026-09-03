class Solution {
    int[] parent;

    int find(int x) {
        if (parent[x] == x) {
            return x;
    }

        return find(parent[x]);
    }

    boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        } 

        parent[rootA] = parent[rootB];
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n + 1];

        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (!union(a,b)) {
                return edge;
            }
        }

        return new int[]{};
    }
}