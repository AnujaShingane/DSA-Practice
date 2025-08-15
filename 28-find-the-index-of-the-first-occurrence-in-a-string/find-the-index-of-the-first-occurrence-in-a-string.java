class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int i = 0;
        int j = m;

        if(m == 0)return 0;
        if(m > n)return -1;

        while(j <= n){
            String sub = haystack.substring(i,j);
            if(sub.equals(needle)){
                return i;
            }
            i++;
            j++;
        }
        return -1;
    }
}