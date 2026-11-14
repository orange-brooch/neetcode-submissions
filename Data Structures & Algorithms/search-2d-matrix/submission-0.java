class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // since the matrix is sorted, we can stretch it out and apply binart search to do better
        // o(logm.n)

        int ROWS = matrix.length; // row count
        int COLS = matrix[0].length; // elements  in the first row

        int l = 0, r = (ROWS * COLS - 1);
        while (l <= r) {
            int m = l + (r - l) / 2;
            int row = m / COLS, col = m % COLS;
            int mid = matrix[row][col];
            if (target < mid) {
                r = m - 1;
            } else if (target > mid) {
                l = m + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
