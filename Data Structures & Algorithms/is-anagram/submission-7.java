class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> charCountS = new HashMap<>();
        HashMap<Character, Integer> charCountT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int sCount = charCountS.getOrDefault(s.charAt(i), 0);
            charCountS.put(s.charAt(i), ++sCount);
            int tCount = charCountT.getOrDefault(t.charAt(i), 0);
            charCountT.put(t.charAt(i), ++tCount);
        }
        for (var entry : charCountS.entrySet()) {
            if (!entry.getValue().equals(charCountT.getOrDefault(entry.getKey(), 0))) {
                return false;
            }
        }
        return true;
    }
}