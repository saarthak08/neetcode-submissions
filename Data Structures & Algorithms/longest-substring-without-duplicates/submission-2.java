class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        int streakStart = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(streakStart));
                streakStart++;
            }
            set.add(c);
            result = Math.max(result, set.size());
        }
        return result;
    }
}
