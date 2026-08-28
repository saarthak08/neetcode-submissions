class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];
        int[] result = new int[nums.length];
        int n = nums.length;

        prefixProduct[0] = 1;
        suffixProduct[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            prefixProduct[i] = nums[i - 1] * prefixProduct[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffixProduct[i] = nums[i + 1] * suffixProduct[i + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = prefixProduct[i] * suffixProduct[i];
        }
        return result; 
    }
}
