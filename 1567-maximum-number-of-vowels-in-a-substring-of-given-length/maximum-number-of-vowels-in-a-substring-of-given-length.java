class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int cnt = 0;
        int maxcnt = 0;

        for(int i = 0 ; i < k ; i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                cnt++;
            }
        }

        int l = 0;
        int r = k-1;
        maxcnt = cnt;

        while(r<n){
            if(isvowel(s.charAt(l))){
                cnt--;
                l++;
            }else if(!isvowel(s.charAt(l))){
                l++;
            }

            r++;
            if(r<n && isvowel(s.charAt(r))){
                cnt++;
            }

            maxcnt = Math.max(maxcnt,cnt);
        }

        return maxcnt;
    }

    public boolean isvowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
            return true;
        }

        return false;
    }
}