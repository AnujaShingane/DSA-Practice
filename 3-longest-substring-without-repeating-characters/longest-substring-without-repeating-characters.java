class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0 , r = 0;
        int maxlen = 0;
        int[] index = new int[256];
        Arrays.fill(index,-1);

        while(r < n){
            if(s.charAt(r) != 0 && index[s.charAt(r)] >= l){
                l = index[s.charAt(r)]+1;
            }

            maxlen = Math.max(maxlen,r-l+1);
            index[s.charAt(r)] = r;
            r++;
        }
        return maxlen;
    }
}