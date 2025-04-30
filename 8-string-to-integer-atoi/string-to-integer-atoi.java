class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1;
        int start = 0;
        long result = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            start = 1;
        } else if (s.charAt(0) == '+') {
            start = 1;
        }

        for (int i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') break;

            int num = ch - '0';
            result = result * 10 + num;

            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int)(sign * result);
    }
}
