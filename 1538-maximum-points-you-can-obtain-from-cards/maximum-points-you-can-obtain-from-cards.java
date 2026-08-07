class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for(int i = 0 ; i < k ; i++){
            sum += cardPoints[i];
        }
        int maxSum = sum;

        int l = k-1;
        int r = n;
        while(r!=n-k){
            sum-=cardPoints[l];
            l--;
            r--;
            sum+=cardPoints[r];
            
            maxSum = Math.max(maxSum,sum);
        }

        return maxSum;
    }
}