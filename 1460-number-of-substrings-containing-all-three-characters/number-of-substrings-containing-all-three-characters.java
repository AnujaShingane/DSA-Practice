class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen,-1);
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){
            lastSeen[s.charAt(i)-'a'] = i;
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                min = Math.min(lastSeen[0], lastSeen[1]);
                min = Math.min(min, lastSeen[2]);
                cnt += min + 1;
            }
        }
        return cnt;
    }
}