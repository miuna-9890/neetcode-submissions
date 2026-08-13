class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int fresh = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r,c});
                } else if(grid[r][c] == 1) {
                        fresh++;
                    }
                }
            }

        int minutes = 0;
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while ((!queue.isEmpty()) && (fresh > 0)) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                for (int[] dir: directions) {
                    int nr = r + dir[0];
                    int cr = c + dir[1];

                    if (nr >= 0 && nr < rows && cr >= 0 && cr < cols) {
                        if (grid[nr][cr] == 1) {
                            grid[nr][cr] = 2;
                            fresh--;
                            queue.offer(new int[]{nr, cr});
                        }
                    }
                }
            }

                minutes++;

        }

        return fresh == 0 ? minutes : -1;
        
    }
}
