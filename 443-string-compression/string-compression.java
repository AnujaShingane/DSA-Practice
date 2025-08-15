class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int j = 0;

        while(j < n){
            char ch = chars[j];
            int start = j;

            while(j < n && chars[j] == ch){
                j++;
            }
            chars[i++] = ch;
            int cnt = j-start;
            if(cnt > 1){
                String str = String.valueOf(cnt);
                for(char c : str.toCharArray()){
                    chars[i++] = c;
                }
            }
        }
        return i;
    }
}