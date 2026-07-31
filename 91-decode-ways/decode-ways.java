class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return func(0,s,dp);
    }

    public int func(int ind,String s,int[] dp) {
        if(ind>=s.length())return 1;
        if(dp[ind]!=-1)return dp[ind];

        int one = 0;
        if(s.charAt(ind)!='0') one = func(ind+1,s,dp);

        String s1 = String.valueOf(s.charAt(ind));
        String s2 = "";
        if(ind<s.length()-1)s2 = String.valueOf(s.charAt(ind+1));
        String s3 = s1.concat(s2);
        int two = 0;
        if(Integer.parseInt(s3)<=26 && Integer.parseInt(s3)>=10 && s3.charAt(0)!='0'){
            two = func(ind+2,s,dp);
        }

        return dp[ind] = one + two;
    }
}