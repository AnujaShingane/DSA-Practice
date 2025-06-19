class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return number(nums, k) - number(nums, k-1);
    }

    public int number(int[] nums, int k) {
        int n = nums.length;
        int l = 0 , r = 0;
        int cnt = 0;
        int sum = 0;

        if(k < 0) return 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i]%2 == 0)nums[i] = 0;
            else nums[i] = 1;
        }

        while(r < n){
            sum += nums[r];

            while(sum > k){
                sum -= nums[l];
                l++;
            }

            if(sum <= k){
                cnt += r-l+1;
            }
            r++;
        }
        return cnt;
    }
}