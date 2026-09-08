class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        int l = 0;
        int maxF = 0;
        int result = k;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            maxF = Math.max(maxF, charCount.get(c));
            while ((i - l + 1) - maxF > k) {
                charCount.put(s.charAt(l), charCount.get(s.charAt(l)) - 1);
                l++;
            }
            result = Math.max(result, i - l + 1);
        }
        return result;
    }
}
