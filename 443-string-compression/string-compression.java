class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int i = 0;

        while(i<n){
            int j = i;
            while (j < n && chars[j] == chars[i]) j++;
            cnt = j - i;
            if(cnt==1)sb.append(chars[i]);
            if (cnt > 1){
                sb.append(chars[i]);
                sb.append(cnt);  
            }      // writes all digits
            i = j;
        }

        String str = sb.toString();
        for(i=0; i<str.length();i++){
            chars[i] = str.charAt(i);
        }
        return str.length();
    }
}