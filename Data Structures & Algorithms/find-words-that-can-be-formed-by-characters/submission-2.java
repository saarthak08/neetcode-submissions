class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCounts = new int[26];

        for(int i=0; i<chars.length(); i++) {
            charCounts[chars.charAt(i) - 'a']++;
        }
        int c=0;
        for(int i =0; i<words.length; i++) {
            int[] wordCounts = new int[26];
            boolean possible = true;
            for(int j=0; j<words[i].length(); j++) {
                int index = words[i].charAt(j) - 'a';
                wordCounts[index]++;
                if(wordCounts[index] > charCounts[index]) {
                    possible = false;
                    break;
                }
            }
            if (possible) c += words[i].length();
        }
        return c;
    }
}