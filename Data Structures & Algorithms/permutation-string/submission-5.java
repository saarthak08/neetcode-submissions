class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int count = map.computeIfAbsent(s1.charAt(i), key -> 0);
            map.put(s1.charAt(i), ++count);
        }
        HashMap<Character, Integer> currentFind = new HashMap<>();
        int findCount = 0;
        int startCount = -1;
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c) && map.get(c) != 0) {
                int cnt = map.get(c);
                map.put(c, --cnt);
                if (findCount == 0) {
                    startCount = i;
                }
                findCount++;
                if (findCount == s1.length()) {
                    return true;
                }
            } else {
                if (findCount != 0) {
                    while (startCount < i) {
                        char x = s2.charAt(startCount);
                        int cnt = map.get(x);
                        startCount++;
                        if (x == c) {
                            break;
                        } else {
                            map.put(x, ++cnt);
                            findCount--;
                        }
                    }
                }
            }
        }
        return false;
    }
}
