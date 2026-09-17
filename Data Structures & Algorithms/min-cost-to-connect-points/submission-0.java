/*Generate every possible pair of points using two loops.
Calculate the Manhattan distance for each pair.
Store each pair + its cost as an edge.
Sort all edges by cost.
Go through edges from cheapest → most expensive.
For each edge:
find(a) and find(b)
If they have the same root → skip because it creates a cycle.
Otherwise → union(a, b) and add the cost.
Stop after adding n - 1 edges.*/

class Edge {
    int a;
    int b;
    int cost;

    public Edge(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
}

class Solution {
            int[] parent;

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs((points[i][0] - points[j][0])) + Math.abs((points[i][1] - points[j][1])); 
                Edge edge = new Edge(i, j, dist);
                edges.add(edge);
            }
        }

edges.sort((a, b) -> Integer.compare(a.cost, b.cost));
        int cost = 0;
int edgesUsed = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge e = edges.get(i);
            if (find(e.a) == find(e.b)) {
                continue;
            }
            union(e.a, e.b);
            cost += e.cost;
            edgesUsed += 1;
            if (edgesUsed == n-1) {
                break;
            }
        }
        return cost;

    }

    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        parent[rootA] = rootB;
    }
}
