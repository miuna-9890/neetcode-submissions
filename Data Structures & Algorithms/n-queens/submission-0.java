class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row: board) {
            Arrays.fill(row, '.');
        }

        dfs(0, n, board, ans);
        return ans;
    }

    public void dfs(int row, int n, char[][] board, List<List<String>> ans) {

        if (row == n) {
            List<String> soln = new ArrayList<>();
            for (char[] c: board) {
                soln.add(new String(c));
            }
            ans.add(new ArrayList<>(soln));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (valid(board, row, col)) {
                board[row][col] = 'Q';
                dfs(row + 1, n, board, ans);
                board[row][col] = '.';
            }
        }
    }

    public boolean valid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length ; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
