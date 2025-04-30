class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty()) return 0;
        int sign = 1;
        long ans = 0;
        int start = 0;

        if(s.charAt(0) == '-'){
            start = 1;
            sign = -1;
        }else if(s.charAt(0) == '+'){
            start = 1;
            sign = 1;
        }

        for(int i = start ; i < s.length() ; i++){
            int ch = s.charAt(i);
            if(ch < '0' || ch > '9') break;

            int num = ch - '0';
            ans = ans * 10 + num;

            if(ans*sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(ans*sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }

        return (int) (sign*ans);
    }
}