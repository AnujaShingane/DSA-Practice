class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n+1][m+1];

        return func(s,p,n,m,dp);
    }

    public boolean func(String s1, String s2,int i , int j,Boolean[][] dp) {
        if(i==0 && j==0)return true;
        if(i==0 && j>=1){
            for(int k = 1 ; k <= j ; k++){
                if(s2.charAt(k-1) != '*')return false;
            }
            return true;
        }
        if(j==0 && i>=1)return false;

        if(dp[i][j] != null)return dp[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1) || s2.charAt(j-1) == '?'){
            return dp[i][j]=func(s1,s2,i-1,j-1,dp);
        }else if(s2.charAt(j-1) == '*')return dp[i][j]=func(s1,s2,i,j-1,dp) || func(s1,s2,i-1,j,dp);
        else return dp[i][j]=false;
    }
}