class Solution {
    public List<String> commonChars(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            HashMap<Character, Integer> currCount = new HashMap<>();
            for (Character c : word.toCharArray()) {
                int cnt = currCount.computeIfAbsent(c, k -> 0);
                currCount.put(c, ++cnt);
            }
            for (var entry : currCount.entrySet()) {
                result.put(entry.getKey(),
                    i == 0 ? entry.getValue()
                           : Math.min(entry.getValue(),
                                 result.computeIfAbsent(entry.getKey(), (key) -> 0)));
            }
            if (i != 0) {
                for (var entry : result.entrySet()) {
                    result.put(entry.getKey(),
                        i == 0 ? entry.getValue()
                               : Math.min(entry.getValue(),
                                     currCount.computeIfAbsent(entry.getKey(), (key) -> 0)));
                }
            }
        }
        for (var entry : result.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                res.add(entry.getKey().toString());
            }
        }
        return res;
    }
}