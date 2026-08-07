class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int sum = 0;

        for(int i = 0 ; i < n ; i++){
            if(grumpy[i]==0)sum += customers[i];
        }

        int currSum = 0;
        for(int i = 0 ; i < minutes ; i++){
            if(grumpy[i]==1)currSum += customers[i];
        }
        int maxSum = currSum;

        int l = 0;
        int r = minutes-1;
        while(r<n){
            if(grumpy[l]==1){
                currSum -= customers[l];
                l++;
            }else{
                l++;
            }

            r++;
            if(r<n && grumpy[r]==1){
                currSum += customers[r];
            }
            maxSum = Math.max(maxSum,currSum);
        }

        return sum + maxSum;
    }
}