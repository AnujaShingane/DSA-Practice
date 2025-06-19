class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0, rsum = 0;
        int sum = 0;
        int maxSum = 0;

        for(int i = 0 ; i < k ; i++){
            lsum += cardPoints[i];
        }
        maxSum = lsum;
        int rightIndex = n-1;
        for(int i = k-1 ; i >= 0 ; i--){
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[rightIndex--];
            maxSum = Math.max(maxSum,lsum+rsum);
        }
        return maxSum;
    }
}