class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i = 0 ; i <= n ; i++){
            int num = i;
            int cnt = 0;
            while(num!=0){
                num = (num & (num-1));
                cnt++;
            }
            ans[i] = cnt;
        }

        return ans;
    }
}