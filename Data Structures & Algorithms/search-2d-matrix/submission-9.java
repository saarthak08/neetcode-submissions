class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;
        int rNum = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target >= matrix[m][0] && target <= matrix[m][matrix[m].length - 1]) {
                rNum = m;
                break;
            }
            if (target >= matrix[l][0] && target < matrix[m][0]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (rNum == -1) {
            return false;
        }
        l = 0;
        r = matrix[rNum].length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (matrix[rNum][m] == target) {
                return true;
            }
            if (matrix[rNum][l] <= target && matrix[rNum][m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
