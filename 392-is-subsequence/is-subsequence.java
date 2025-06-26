class Solution {
    public boolean isSubsequence(String s, String t) {
        int l = 0;
        int r = 0;
        if(s.equals(""))return true;

        while(l < s.length() && r < t.length()){
            if(s.charAt(l) == t.charAt(r)){
                l++;
                r++;
            }else r++;
        }

        if( l < s.length()) return false;
        return true;
    }
}