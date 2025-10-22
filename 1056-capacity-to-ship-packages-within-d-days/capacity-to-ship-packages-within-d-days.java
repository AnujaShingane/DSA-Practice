class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low=Integer.MIN_VALUE; // max in arr
        int high=0; // sum of array
        for(int i = 0 ; i < n ; i++){
            if(weights[i]>low)low=weights[i];
            high+=weights[i];
        }
        int ans = -1;

        while(low<=high){
            int mid = (low+high)/2;
            int findDays = findDays(weights,mid);

            if(findDays<=days){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public int findDays(int[] weights,int x){
        int n = weights.length;
        int i = 0;
        int cnt =0;
        int sum=0;

        while(i<n){
            sum+=weights[i];
            if(sum>x){
                cnt++;
                sum=weights[i];
            }
            i++;
        }
        return cnt+1;
    }
}