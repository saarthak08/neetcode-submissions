class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        if (s.length() == 1) {
            return true;
        }
        while (l <= r) {
            while (!((s.charAt(l) >= 'A' && s.charAt(l) <= 'Z')
                || (s.charAt(l) >= 'a' && s.charAt(l) <= 'z')
                || (s.charAt(l) >= '0' && s.charAt(l) <= '9'))) {
                l++;
                if (l > r || l >= s.length()) {
                    return true;
                }
            }

            while (!((s.charAt(r) >= 'A' && s.charAt(r) <= 'Z')
                || (s.charAt(r) >= 'a' && s.charAt(r) <= 'z')
                || (s.charAt(r) >= '0' && s.charAt(r) <= '9'))) {
                r--;
                if (l > r || r < 0) {
                    return true;
                }
            }

            int left = s.charAt(l);
            int right = s.charAt(r);

            if (left >= 'A' && left <= 'Z') {
                left = left + 32;
            }

            if (right >= 'A' && right <= 'Z') {
                right = right + 32;
            }

            if (left != right) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
