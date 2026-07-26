class Solution {
    public String largestGoodInteger(String num) {
        int largestInteger = -1;
        if (num.length() < 3) {
            return "";
        }
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                int digit = num.charAt(i) - 48;
                System.out.println(digit);
                int currentLargestInteger = digit * 100 + digit * 10 + digit;
                if (largestInteger < currentLargestInteger) {
                    largestInteger = currentLargestInteger;
                }
            }
        }
        return largestInteger == -1 ? ""
            : largestInteger == 0   ? "000"
                                    : String.valueOf(largestInteger);
    }
}