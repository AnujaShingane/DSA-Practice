class Solution {
    public int lowerBound(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = n;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] >= target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public int upperBound(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = n;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] > target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lb = lowerBound(nums,target);
        int ub = upperBound(nums,target);

        int[] res = new int[2];
        
        if(lb == n || nums[lb] != target){
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        res[0] = lb;
        res[1] = ub-1;
        return res;
    }
}