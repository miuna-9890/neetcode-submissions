class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));

        for (List<String> ticket: tickets) {
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new PriorityQueue<>());
            }
            map.get(ticket.get(0)).offer(ticket.get(1));
        }

        LinkedList<String> res = new LinkedList<>();

        dfs("JFK", map, res);
        return res;
    }

    private void dfs(String node, Map<String, PriorityQueue<String>> map, List<String> ans) {

PriorityQueue<String> dest = map.get(node);
        while(dest != null && !dest.isEmpty()) {
            String next = dest.poll();
            dfs(next, map, ans);
        }

        ans.addFirst(node);
    }
}
