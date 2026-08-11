/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        for (int i = 0; i < node.neighbors.size(); i++) {
            dfs(node, node.neighbors.get(i), map);
        }

        return map.get(node);
    }

    public void dfs(Node node, Node neighbor, HashMap<Node, Node> map) {
        if (map.containsKey(neighbor)) {
            map.get(node).neighbors.add(map.get(neighbor));
            return;
        }
        Node neigh = new Node(neighbor.val);
        map.put(neighbor, neigh);
        map.get(node).neighbors.add(neigh);
        
        for (int i = 0; i < neighbor.neighbors.size(); i++) {
            dfs(neighbor, neighbor.neighbors.get(i), map);
        }
    }
}