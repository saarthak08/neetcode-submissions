class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> cnt = new HashMap<>();
        for(Character c: s.toCharArray()) {
            int ct = cnt.computeIfAbsent(c, k -> 0);
            cnt.put(c, ++ct);
        }
        int res =0;
        boolean hasOdd = false;
        for(var entry: cnt.entrySet()) {
            if(entry.getValue()%2==0) {
                res += entry.getValue();
            } else {
                res += entry.getValue() - 1;
                hasOdd = true;
            }
        }
        if (hasOdd) res += 1;
        return res;
    }
}