class Solution {
    public int maxOnes(int arr[], int k) {
        int n = arr.length;
        int zeros=0;
        int maxlen = 0;
        int l = 0;
        int r = 0;
        
        while(r<n){
            if(arr[r]==0)zeros++;
            
            if(zeros<=k)maxlen=Math.max(maxlen,r-l+1);
            
            while(zeros>k){
                if(arr[l]==0)zeros--;
                l++;
            }
            r++;
        }
        
        return maxlen;
    }
}