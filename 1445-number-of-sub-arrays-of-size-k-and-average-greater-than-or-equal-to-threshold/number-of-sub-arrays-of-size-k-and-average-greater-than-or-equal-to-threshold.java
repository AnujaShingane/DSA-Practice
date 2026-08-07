class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int l = 0;
        int r = k-1;
        int sum = 0;

        for(int i = 0 ; i < k ; i++){
            sum += arr[i];
        }
        int avg = sum/k;
        int cnt = 0;
        if(avg>=threshold)cnt=1;

        while(r<n-1){
            sum-=arr[l];
            l++;
            r++;
            sum+=arr[r];
            
            avg = sum/k;
            if(avg>=threshold)cnt++;
        }

        return cnt;
    }
}