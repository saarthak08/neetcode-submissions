class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        int streakStart = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                if (set.size() > result) {
                    result = set.size();
                }
                while (set.contains(c)) {
                    set.remove(s.charAt(streakStart));
                    streakStart++;
                }
            }
            set.add(c);
        }
        if (set.size() > result) {
            result = set.size();
        }
        return result;
    }
}
