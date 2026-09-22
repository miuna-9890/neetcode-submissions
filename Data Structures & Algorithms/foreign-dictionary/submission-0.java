// The first different character tells us the ordering:
// for every adjacent pair of words:
// compare characters from left → right
// find first different pair
// create an edge
// STOP comparing this pair

// if all characters matched
// AND first word is longer than second word
// → invalid

class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> graph = new HashMap<>();

      for (String word: words) {
        for (int i = 0; i < word.length(); i++) {
            if (!graph.containsKey(word.charAt(i))) {
               graph.put(word.charAt(i), new HashSet<>());
            }
        }
      }

      for (int i = 1; i < words.length; i++) {
        int j = 0;
        String curr = words[i];
        String prev = words[i - 1];
        while(j < curr.length() && j < prev.length()) {
            if (curr.charAt(j) == prev.charAt(j)) {
                j++;
                continue;
            } else {
                graph.get(prev.charAt(j)).add(curr.charAt(j));
                break;
            }
        }
        if (j == curr.length() && prev.length() > curr.length()) {
            return "";
        }
      }

      Map<Character, Integer> visited = new HashMap<>();
      List<Character> result = new ArrayList<>();

      for (char c: graph.keySet()) {
        if (dfs(c, graph, visited, result)) {
            return "";
        }
      }

      Collections.reverse(result);

      StringBuilder ans = new StringBuilder();

      for (char c: result) {
        ans.append(c);
      }
      return ans.toString();

    }

    private boolean dfs(char c, Map<Character, Set<Character>> graph, Map<Character, Integer> visited, List<Character> result ) {
    // check state
    if (visited.get(c) != null && visited.get(c) == 1) {
        return true;
    }

    if (visited.get(c) != null && visited.get(c) == 2) {
    return false;
}
    // mark visiting
    visited.put(c, 1);
    // visit neighbours
    Set<Character> neighbours = graph.getOrDefault(c, new HashSet<>());

    for (char neigh: neighbours) {
            if (dfs(neigh, graph, visited, result)) {
        return true;
    }
    }
    // mark visited
    visited.put(c, 2);
    // add to result
    result.add(c);
    return false;
}
}
