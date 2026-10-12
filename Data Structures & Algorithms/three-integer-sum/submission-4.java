class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int x = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int y = nums[j];
                int z = nums[k];
                if (x + y + z == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(x);
                    res.add(y);
                    res.add(z);
                    result.add(res);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (x + y + z > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
