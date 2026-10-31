class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;
        int targetRow = -1;
        int colLen = matrix[0].length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (matrix[m][0] <= target && matrix[m][colLen] >= target) {
                targetRow = m;
                break;
            }
            if (matrix[m][0] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (targetRow == -1) {
            return false;
        }
        l = 0;
        r = colLen;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (matrix[targetRow][m] == target) {
                return true;
            } else if (matrix[targetRow][m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
