class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(nums[low]==nums[mid])if(nums[low]==target)return mid;
            else{
                low=mid+1;
                return BS(nums,low,high,target);
            }
            else if(nums[mid]==nums[high])if(nums[mid]==target)return mid;
            else high=mid-1;BS(nums,low,high,target);
            if(nums[low]<nums[mid]){
                //left sorted
                if(nums[low]<=target && target<=nums[mid]){
                    return BS(nums,low,mid,target);
                }else{
                    low=mid+1;
                }
            }else{
                // right sorted
                if(nums[mid]<=target && target<=nums[high]){
                    return BS(nums,mid,high,target);
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }

    public int BS(int[] nums,int low , int high , int target){
        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]<target){
               low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}