class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> list = new ArrayList<>();
        int r = 0, max = 0;
        while(r < s.length()){
            if(list.contains(s.charAt(r))){
                while(list.contains(s.charAt(r))){
                    list.remove(0);
                }
            }
            list.add(s.charAt(r));
            r++;
            max = Math.max(max, list.size());
        }
        return max;
    }
}