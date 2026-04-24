class Solution {
    public boolean isValidSudoku(char[][] board) {
        // initialize a hashmap, row, col & box
        // value = hashset
        // iterate through row, col (nested loop -> O(n^2))
        // find the corresponding hashmap, retrieve associated value
        // if num exist in hashset, return false, 
        // end of iteration return true

        HashMap<Integer, HashSet<Character>> row = new HashMap<>();
        HashMap<Integer, HashSet<Character>> col = new HashMap<>();
        HashMap<Integer, HashSet<Character>> box = new HashMap<>();

        for (int r = 0; r < board.length; r++) {

            for (int c = 0; c < board[0].length; c++) {
                char val = board[r][c];
                if (val == '.') {
                    continue;
                }

                //row
                if (!row.containsKey(r)) {
                    row.put(r, new HashSet<>());
                }

                if (row.get(r).contains(val)) {
                    return false;
                } else {
                    row.get(r).add(val);
                }

                //col
                if (!col.containsKey(c)) {
                    col.put(c, new HashSet<>());
                }

                if (col.get(c).contains(val)) {
                    return false;
                } else {
                    col.get(c).add(val);
                }

                //box
                int idx = (r / 3) * 3 + (c / 3);
                if (!box.containsKey(idx)) {
                    box.put(idx, new HashSet<>());
                }

                if (box.get(idx).contains(val)) {
                    return false;
                } else {
                    box.get(idx).add(val);
                }
            }
        }

        return true;
    }
}
