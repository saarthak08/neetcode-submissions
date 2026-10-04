class Solution {
    public int trap(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int currHeight = height[i];
            while (!stack.isEmpty() && currHeight > height[stack.peek()]) {
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    int low = stack.peek();
                    res += (Math.min(height[low], currHeight) - height[mid]) * (i - low - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }
}
