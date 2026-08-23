class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] diff = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            diff[i] = target - nums[i];
            map.put(nums[i], i);
        }

        for (int i = 0; i < diff.length; i++) {
            if (map.containsKey(diff[i]) && map.get(diff[i]) != i) {
                return new int[] {i, map.get(diff[i])};
            }
        }
        return new int[] {};
    }
}
