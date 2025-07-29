class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        for(int i = n-1 ; i >= 0 ; i--){
            int digit = num.charAt(i) - '0';
            if(digit % 2 == 1){
                return str(i,num);
            }
        }
        return "";
    }

    public String str(int ind,String num) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <= ind ; i++){
            sb.append(num.charAt(i));
        }
        return sb.toString();
    }
}