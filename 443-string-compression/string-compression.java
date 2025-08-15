class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int j = 0;
        int n = chars.length;

        while(j < n){
            char ch = chars[j];
            int start = j;

            while(j < n && chars[j] == ch){
                j++;
            }
            chars[i++] = ch;
            int cnt = j-start;

            if(cnt > 1){
                String cntStr = String.valueOf(cnt);
                for(char c : cntStr.toCharArray()){
                    chars[i++] = c;
                }
            }
        }
        return i;
    }
}