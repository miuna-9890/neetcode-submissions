class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        int index = -1;

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
        TrieNode curr = root;
            for (char c: words[i].toCharArray()) {
                int idx = c - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.isEnd = true;
            curr.index = i;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(root, board, i, j, ans, words);
            }
        }
        return ans;
    }

    public void dfs(TrieNode root, char[][] board, int i, int j, List<String> ans, String[] words) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        if (board[i][j] == '#') {
            return;
        }

        char c = board[i][j];
        int idx = c - 'a';
        TrieNode next = root.children[idx];
        if (next == null) {
            return;
        }

        if (next.isEnd && next.index != -1) {
            ans.add(words[next.index]);
            next.index = -1;
        }

        board[i][j] = '#';

        dfs(next, board, i + 1, j, ans , words);
        dfs(next, board, i - 1, j, ans , words);
        dfs(next, board, i, j + 1, ans , words);
        dfs(next, board, i, j - 1, ans , words);

        board[i][j] = c;
    }
}
