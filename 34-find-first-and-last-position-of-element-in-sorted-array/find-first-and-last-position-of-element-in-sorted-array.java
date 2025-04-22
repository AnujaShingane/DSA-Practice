class Solution {
    public int firstOccurance(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = -1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == target){
                ans = mid;
                high = mid-1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

    public int lastOccurance(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = -1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == target){
                ans = mid;
                low = mid+1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int first = firstOccurance(nums,target);
        if(first == -1){
            res[0] = -1;
            res[1] = -1;
        }
        int last = lastOccurance(nums,target);
        res[0] = first;
        res[1] = last;
        return res;
    }
}