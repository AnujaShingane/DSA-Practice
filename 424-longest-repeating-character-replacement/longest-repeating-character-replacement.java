class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0 , r = 0;
        int maxlen = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;

        while(r < n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));

            while((r - l + 1) - maxFreq > k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            
            if((r - l + 1) - maxFreq <= k){
                maxlen = Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}