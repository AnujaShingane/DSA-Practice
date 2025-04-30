class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int i = 0, sign = 1;
        long result = 0;

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if(s.charAt(i) == '-'){
                sign = -1;
            }else{
                sign = 1;
            }
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i++) - '0');
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int)(sign * result);
    }
}
