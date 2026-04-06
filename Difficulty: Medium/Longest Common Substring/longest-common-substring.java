class Solution {
    public int longCommSubstr(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        
        int max = 0;
        for(int i = 0 ; i < n1 ; i++){
            for(int j = 0 ; j < n2 ; j++){
                max = Math.max(max,func(i,j,s1,s2,dp));
            }
        }
        return max;
    }
    
    public static int func(int ind1,int ind2,String s1,String s2,int[][] dp){
        if(ind1<0 || ind2<0)return 0;

        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];

        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2] = 1 + func(ind1-1,ind2-1,s1,s2,dp);
        }else{
            return dp[ind1][ind2] = 0;
        }
    }
}