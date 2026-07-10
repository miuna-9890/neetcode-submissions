class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (dfs(board, word, 0, row, col, visited)) {
                    return true;
                }
            }
        }
        return false;
        
    }

    public boolean dfs(char[][] board, String word, int i, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if (visited[row][col]) {
            return false;
        }

        if (board[row][col] != word.charAt(i)) {
            return false;
        }

        if (i == word.length() - 1) {
            return true;
        }

        visited[row][col] = true;

        boolean found =
                dfs(board, word, i + 1, row + 1, col, visited) ||
                dfs(board, word, i + 1, row - 1, col, visited) ||
                dfs(board, word, i + 1, row, col + 1, visited) ||
                dfs(board, word, i + 1, row, col - 1, visited);

        visited[row][col] = false;
        return found;
    }
}