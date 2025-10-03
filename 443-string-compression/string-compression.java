class Solution {
    public int compress(char[] chars) {
        int  n = chars.length;
        int i=0;
        int j=0;
        int cnt=0;
        StringBuilder sb = new StringBuilder();

        while(j<n){
            while(j<n && chars[i]==chars[j]){
                cnt++;
                j++;
            }
            if(cnt==1)sb.append(chars[i]);
            else{
                sb.append(chars[i]);
                sb.append(cnt);
            }
            i=j;
            cnt=0;
        }

        for(i=0; i<sb.length() ;i++){
            chars[i]=sb.charAt(i);
        }
        return sb.length();
    }
}