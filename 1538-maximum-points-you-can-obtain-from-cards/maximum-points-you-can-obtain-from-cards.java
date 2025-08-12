class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = k-1;
        int r = n-1;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0 ; i < k ; i++){
            sum += cardPoints[i];
        }
        maxSum = sum;

        while(l != -1){
            sum -= cardPoints[l];
            l--;
            sum += cardPoints[r];
            r--;
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}