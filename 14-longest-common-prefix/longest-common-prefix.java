class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        char[] ch1 = strs[0].toCharArray();
        char[] ch2 = strs[n-1].toCharArray();
        
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < ch1.length){
            if(ch1[i] != ch2[i])break;
            sb.append(ch1[i]);
            i++;
        }
        return sb.toString();
    }
}