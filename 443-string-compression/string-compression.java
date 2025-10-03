class Solution {
    public int compress(char[] chars) {
        int n = chars.length, i = 0;
        StringBuilder sb = new StringBuilder();

        while (i < n) {
            int j = i;
            while (j < n && chars[j] == chars[i]) j++;
            sb.append(chars[i]);                 // char of the run
            int cnt = j - i;
            if (cnt > 1) sb.append(cnt);        // writes all digits
            i = j;
        }

        // write back in-place
        for (i = 0; i < sb.length(); i++) chars[i] = sb.charAt(i);
        return sb.length();
    }
}
