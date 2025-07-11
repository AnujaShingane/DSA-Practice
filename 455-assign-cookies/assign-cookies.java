class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0, r = 0;

        while(r < s.length && l < g.length){
            if(s[r] >= g[l]){
                l++;
                r++;
            }else r++;
        }
        return l;
    }
}