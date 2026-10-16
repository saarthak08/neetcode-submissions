class Solution {
  public int characterReplacement(String s, int k) {
    int result = 0;
    int maxF = 0;
    HashMap<Character, Integer> freq = new HashMap<>();
    int l = 0;
    int r = 0;
    while (l < s.length() && r < s.length()) {
      int chars = r - l + 1;
      int fr = freq.computeIfAbsent(s.charAt(r), key -> 0);
      fr++;
      freq.put(s.charAt(r), fr);
      maxF = 0;
      for (int value : freq.values()) {
        maxF = Math.max(value, maxF);
      }
      if (chars - maxF <= k) {
        result = Math.max(result, chars);
        r++;
      } else {
        while (chars - maxF > k) {
          fr = freq.get(s.charAt(l));
          fr--;
          freq.put(s.charAt(l), fr);
          maxF = 0;
          for (int value : freq.values()) {
            maxF = Math.max(value, maxF);
          }
          l++;
          chars = r - l + 1;
        }
        r++;
      }
    }
    return result;
  }
}