class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 1. What should we do if endWord isn't in wordList?
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // 2. Build:
        Map<String, List<String>> map = new HashMap<>();

        for (String word: wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i+1);
                if (!map.containsKey(pattern)) {
                    map.put(pattern, new ArrayList<>());
                }
                map.get(pattern).add(word);
            }
        }

        // 3. For every word:
        //    generate "*ot", "h*t", "ho*" style patterns
        //    put the word into map[pattern]

        // 4. BFS
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int levels = 1;
        queue.add(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String word = queue.poll();
                if (word.equals(endWord))  {                  
                    return levels;
                }
                for (int i = 0; i < word.length(); i++) {
                    String pattern = word.substring(0, i) + "*" + word.substring(i+1);
                    if (map.containsKey(pattern)) {
                        List<String> words = map.get(pattern);
                        for (String nextWord: words) {
                            if (!visited.contains(nextWord)) {
                                visited.add(nextWord);
                                queue.offer(nextWord);
                            }
                        }
                    }
                }
            }
            levels++;
        }
        return 0;

        // ...

    }
}