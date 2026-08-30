class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        HashSet<Integer> counted = new HashSet<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (counted.contains(nums[i])) {
                continue;
            }
            int currNum = nums[i] + 1;
            while (numSet.contains(currNum)) {
                count++;
                currNum++;
                counted.add(currNum);
            }
            currNum = nums[i] - 1;
            while (numSet.contains(currNum)) {
                count++;
                currNum--;
                counted.add(currNum);
            }
            counted.add(currNum);
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
}
