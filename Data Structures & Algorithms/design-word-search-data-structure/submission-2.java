class WordDictionary {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c: word.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int i, TrieNode root) {
        if (root == null) {
            return false;
        }
        if (i == word.length()) {
            return root.isEnd;
        }

        char c = word.charAt(i);

        if (c == '.') {

            for(TrieNode child: root.children) {
                if (child != null && dfs(word, i+1, child)) {
                    return true;
                    }
                }
                return false;
            }

        return dfs(word, i + 1, root.children[c - 'a']);
    }
}
