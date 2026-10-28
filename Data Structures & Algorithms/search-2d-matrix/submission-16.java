class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = -1;
        int l = 0;
        int r = matrix.length - 1;
        int colLen = matrix[0].length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (matrix[m][0] <= target && matrix[m][colLen] >= target) {
                row = m;
                break;
            }
            if (target < matrix[m][0]) {
                r = m - 1;
            }
            if (target > matrix[m][colLen]) {
                l = m + 1;
            }
        }
        System.out.println(row);
        if (row == -1) {
            return false;
        }
        l = 0;
        r = colLen;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (matrix[row][m] == target) {
                return true;
            }
            if (matrix[row][m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
