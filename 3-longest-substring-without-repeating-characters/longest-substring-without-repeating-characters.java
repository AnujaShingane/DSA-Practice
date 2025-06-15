class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int maxlen = 0;
        int[] hash = new int[256];
        int n = s.length();
        Arrays.fill(hash,-1);

        while(r < n){
            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)] + 1; 
                }
            }

            maxlen = Math.max(maxlen,r-l+1);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxlen;
    }
}