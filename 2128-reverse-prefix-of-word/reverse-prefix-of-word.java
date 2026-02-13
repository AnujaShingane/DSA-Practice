class Solution {
    public String reversePrefix(String word, char ch) {
        int n = word.length();
        int idx = 0;

        for(int i = 0 ; i < n ; i++){
            if(word.charAt(i)==ch){
                idx = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        String subStr = word.substring(0,idx+1);
        String remStr = word.substring(idx+1);

        sb.append(subStr);
        sb.reverse();
        sb.append(remStr);

        return sb.toString();
    }
}