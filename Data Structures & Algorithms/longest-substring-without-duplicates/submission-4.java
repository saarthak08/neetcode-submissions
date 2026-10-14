class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> currSet = new HashSet<>();
        int maxString = 0;
        int l = 0;
        int r = 0;
        int currString = 0;
        while(l < s.length() && r < s.length()) {
            char a = s.charAt(l);
            char b = s.charAt(r);
            if(!currSet.contains(b)) {
                currSet.add(b);
                currString++;
                if(maxString < currString) {
                    maxString = currString;
                }
                r++;
            } else {
                while(s.charAt(l)!=b) {
                    currSet.remove(s.charAt(l));
                    l++;
                    currString--;
                }
                currSet.remove(s.charAt(l));
                l++;
                currString--;
            }
        }  
        return maxString;
    }
}
