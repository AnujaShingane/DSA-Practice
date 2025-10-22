class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            if(piles[i]>high)high=piles[i];
        }

        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            long findHrs = findHrs(piles,mid);

            if(findHrs<=h){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static long findHrs(int[] piles , int x){
        long cnt = 0;
        for(int num : piles){
            if(num<=x)cnt++;
            else{
                int quo= num/x;
                int rem = num%x;
                cnt+=quo;
                if(rem!=0)cnt++;
            }
        }
        return cnt;
    }
}