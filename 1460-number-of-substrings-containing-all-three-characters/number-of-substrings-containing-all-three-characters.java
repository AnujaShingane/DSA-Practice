class Solution {
    public int numberOfSubstrings(String s) {
        int goal = 3;
        return number(s, goal) - number(s, goal-1);
    }

    public int number(String s, int goal) {
        int n = s.length();
        int l = 0 , r = 0;
        int cnt = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        if(goal < 0) return 0;

        while(r < n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);

            while(map.size() > goal){
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }

            if(map.size() <= goal){
                cnt +=  r-l+1;
            }
            r++;
        }
        return cnt;
    }
}