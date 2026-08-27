class Solution {
    public String encode(List<String> strs) {
        StringBuilder resultBuilder = new StringBuilder();
        for (String str : strs) {
            resultBuilder.append(str.length()).append("#").append(str);
        }
        return resultBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            
            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            result.add(str.substring(j + 1, i));
        }
        return result;
    }
}