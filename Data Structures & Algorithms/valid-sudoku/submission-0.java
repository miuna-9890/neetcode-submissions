class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            col[i] = new HashSet<Character>();
            row[i] = new HashSet<Character>();
            box[i] = new HashSet<Character>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];

                if (val == '.') {
                    continue;
                }

                if (col[j].contains(val)) {
                    return false;
                }
                col[j].add(val);

                if (row[i].contains(val)) {
                    return false;
                }
                row[i].add(val);
                
                int c = ( i  / 3 ) * 3 + (j/3);
                if (box[c].contains(val)) {
                    return false;
                }
                box[c].add(val);
            }
        }
        return true;
    }
}
