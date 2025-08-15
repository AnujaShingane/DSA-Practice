class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String longest = "";

        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j <= n ; j++){
                String sub = s.substring(i,j);
                if(isPalindrome(sub) && sub.length() > longest.length()){
                    longest = sub;
                }
            }
        }
        return longest;
    }

    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length()-1;

        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}