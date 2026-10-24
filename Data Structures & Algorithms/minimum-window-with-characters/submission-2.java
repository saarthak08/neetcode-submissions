class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tFreqMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int freq = tFreqMap.computeIfAbsent(c, key -> 0);
            tFreqMap.put(c, ++freq);
        }

        String minString = "";
        int minStringLength = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> currentFreqMap = new HashMap<>();
        while (l < s.length() && r < s.length()) {
            char c = s.charAt(r);
            int freq = currentFreqMap.computeIfAbsent(c, key -> 0);
            currentFreqMap.put(c, ++freq);
            boolean isFound = true;
            for (var entry : tFreqMap.entrySet()) {
                if (currentFreqMap.computeIfAbsent(entry.getKey(), key -> 0) < entry.getValue()) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                while (l < r) {
                    char cTemp = s.charAt(l);
                    int tempFreq = currentFreqMap.get(cTemp);
                    tempFreq--;
                    if (tempFreq < tFreqMap.computeIfAbsent(cTemp, key -> 0)) {
                        break;
                    } else {
                        currentFreqMap.put(cTemp, tempFreq);
                        l++;
                    }
                }
                if (r - l + 1 < minStringLength) {
                    minString = s.substring(l, r + 1);
                    minStringLength = r - l + 1;
                }
            }
            r++;
        }
        return minString;
    }
}
