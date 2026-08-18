class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int rowNum = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m][0] > target) {
                r = m - 1;
            } else if (arr[m][arr[m].length - 1] < target) {
                l = m + 1;
            } else {
                rowNum = m;
                break;
            }
        }
        if (rowNum == -1) {
            return false;
        }
        l = 0;
        r = arr[rowNum].length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[rowNum][m] == target) {
                return true;
            }
            if (arr[rowNum][m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
