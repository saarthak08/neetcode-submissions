class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            int[] chars = new int[26];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }
            StringBuilder st = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                st.append(chars[i] + "_");
            }
            String x = st.toString();
            List l = res.computeIfAbsent(x, k -> new ArrayList<>());
            l.add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for (var value : res.values()) {
            result.add(value);
        }
        return result;
    }
}
