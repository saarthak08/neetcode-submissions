class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int x = i + 1;
            int y = nums.length - 1;
            while (x < y) {
                int b = nums[x];
                int c = nums[y];
                if (a + b + c == 0) {
                    result.add(Arrays.asList(a, b, c));
                    y--;
                    x++;
                    while (x < y && nums[x]==nums[x-1]) {
                        x++;
                    } 
                } else if (a + b + c > 0) {
                    y--;
                } else {
                    x++;
                }
            }
        }

        return result;
    }
}
