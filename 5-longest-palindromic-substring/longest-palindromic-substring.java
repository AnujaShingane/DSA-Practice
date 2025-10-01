class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        String res = s.substring(0, 1); // at least one char
        int maxlen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {   // j is EXCLUSIVE → allow j == n
                String str = s.substring(i, j);
                int len = j - i;
                if (len <= maxlen) continue;     // simple pruning
                if (isPalindrome(str)) {
                    maxlen = len;                // <-- update maxlen!
                    res = str;                   // keep the best substring
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length()-1;

        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}