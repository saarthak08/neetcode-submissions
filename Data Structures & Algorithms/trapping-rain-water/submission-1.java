public class Solution {
    public int trap(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int mid = height[stack.pop()];
                if (!stack.isEmpty()) {
                    int left = height[stack.peek()];
                    int right = height[i];
                    res += (Math.min(left, right) - mid) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }
}