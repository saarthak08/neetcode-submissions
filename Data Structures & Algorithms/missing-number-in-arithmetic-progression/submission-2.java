class Solution {
    public int missingNumber(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        int diff = (arr[r] - arr[0]) / arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            int expectedValue = arr[0] + m * diff;
            if (arr[m] == expectedValue) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return arr[0] + l * diff;
    }
}
