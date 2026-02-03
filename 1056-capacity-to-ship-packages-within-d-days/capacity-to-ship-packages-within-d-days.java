class Solution {
    public int shipWithinDays(int[] weights, int days) {    
        int n = weights.length;
        int low = Integer.MIN_VALUE;  // max in array
        int high = 0; //sum of all
        int ans = -1;

        for(int num : weights){
            low = Math.max(low,num);
            high+=num;
        }

        while(low<=high){
            int mid = (low+high)/2;
            int daysGot = days(weights,mid);

            if(daysGot<=days){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }

    public static int days(int[] weights, int capacity){
        int cnt = 0;
        int n = weights.length;
        int sum = 0;
        int i = 0;

        while(i<n){
            sum+=weights[i];

            if(sum>capacity){
                cnt++;
                sum = weights[i];
            }
            i++;
        }

        return cnt+1;
    }
}