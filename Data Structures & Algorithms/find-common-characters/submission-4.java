class Solution {
    public List<String> commonChars(String[] words) {
        // Initialize with a large number (e.g., MAX_VALUE) so first word's counts are taken.
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            // Count frequencies for this word
            int[] curFreq = new int[26];
            for (char c : word.toCharArray()) {
                curFreq[c - 'a']++;
            }

            // Keep the minimum frequency across all processed words
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], curFreq[i]);
            }
        }

        // Build result list using the stored minimum frequencies
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                res.add(String.valueOf((char) ('a' + i)));
            }
        }
        return res;
    }
}