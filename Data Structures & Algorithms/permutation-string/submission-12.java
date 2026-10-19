class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int freq = freqMap.computeIfAbsent(s1.charAt(i), key -> 0);
            freqMap.put(s1.charAt(i), ++freq);
        }
        int start = -1;
        HashMap<Character, Integer> currMap = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            int currFreq = currMap.computeIfAbsent(c, key -> 0);
            currFreq++;
            currMap.put(c, currFreq);
            int mainFreq = freqMap.computeIfAbsent(c, key -> 0);
            if (currFreq <= mainFreq) {
                if (start == -1) {
                    start = i;
                }
                if (i - start + 1 == s1.length()) {
                    return true;
                }
            } else {
                while (start!=-1 && start <= i && currMap.get(c) > mainFreq) {
                    char startChar = s2.charAt(start);
                    int startCharFreq = currMap.get(startChar);
                    startCharFreq--;
                    currMap.put(startChar, startCharFreq);
                    start++;
                }
                if (start > i) {
                    start = -1;
                }
            }
        }
        return false;
    }
}
