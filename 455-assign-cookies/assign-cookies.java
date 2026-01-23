class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        int i = 0;
        int j = 0;

        while(i<s.length && j<g.length){
            if(g[j]<=s[i]){
                cnt++;
                i++;
                j++;
            }else{
                i++;
            }
        }

        return cnt;
    }
}