class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                char x = s.charAt(start);
                set.remove(x);
                start++;
            }
            set.add(c);
            result = Math.max(result, set.size());
        }
        return result;
    }
}
