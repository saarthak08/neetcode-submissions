class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProductArray = new int[n];
        int[] suffixProductArray = new int[n];

        prefixProductArray[0] = nums[0];
        suffixProductArray[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefixProductArray[i] = prefixProductArray[i - 1] * nums[i];
            suffixProductArray[(n - 1) - i] = nums[(n - 1) - i] * suffixProductArray[n - i];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[i] = suffixProductArray[1];
            } else if (i == nums.length - 1) {
                result[i] = prefixProductArray[n - 2];
            } else {
                result[i] = prefixProductArray[i - 1] * suffixProductArray[i + 1];
            }
        }
        return result;
    }
}
