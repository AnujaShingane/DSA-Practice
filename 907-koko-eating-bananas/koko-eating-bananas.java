class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = Integer.MIN_VALUE;

        for(int num : piles){
            if(num>high)high=num;
        }

        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            long hrsGot = hrs(piles,mid);

            if(hrsGot<=h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static long hrs(int[] piles,int bpm){
        long cnt = 0;

        for(int num : piles){
            if(num<=bpm)cnt++;
            else{
                int quo = num/bpm;
                int rem = num%bpm;
                cnt+=quo;
                if(rem>0)cnt+=1;
            }
        }
        return cnt;
    }
}