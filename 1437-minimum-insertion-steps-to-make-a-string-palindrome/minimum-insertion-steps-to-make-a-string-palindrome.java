class Solution {
    public int minInsertions(String s) {
        int n1 = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        int[][] dp = new int[n1][n1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return n1 - func(n1-1,n1-1,s,sb.toString(),dp);
    }

    public int func(int i, int j ,String text1,String text2,int[][] dp) {
        if(i<0 || j<0)return 0;
        if(dp[i][j] != -1)return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + func(i-1,j-1,text1,text2,dp);
        }

        return dp[i][j] = Math.max(func(i-1,j,text1,text2,dp),func(i,j-1,text1,text2,dp));
    }
}