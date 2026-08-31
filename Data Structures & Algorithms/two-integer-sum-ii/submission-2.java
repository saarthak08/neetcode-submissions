class Solution {
    public int[] twoSum(int[] a, int target) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            if (a[l] + a[r] == target) {
                return new int[] {l + 1, r + 1};
            } else if (a[l] + a[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[] {-1, -1};
    }
}
