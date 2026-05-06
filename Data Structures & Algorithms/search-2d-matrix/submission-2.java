class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int cols = matrix[0].length;
        int rows = matrix.length;
        int row = -1;

        // find row
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][cols-1]) {
                row = mid;
                break;
            } else if (target > matrix[mid][cols-1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (row == -1) {
            return false;
        }

        int l = 0;
        int r = cols - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (target > matrix[row][mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
