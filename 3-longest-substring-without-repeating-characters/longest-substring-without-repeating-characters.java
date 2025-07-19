class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int cnt = 0;

        while(r < n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0) + 1);
            if(map.get(s.charAt(r)) == 2){
                while(map.get(s.charAt(r)) != 1){
                        map.put(s.charAt(l),map.get(s.charAt(l))-1);
                        if(map.get(s.charAt(l)) == 0){
                            map.remove(s.charAt(l));
                        }
                    l++;
                }
            }
            cnt = Math.max(cnt,r-l+1);
            r++;
        }
        return cnt;
    }
}