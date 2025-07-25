class Solution {
    public void sortColors(int[] nums) {
        // Initialize: low = 0, mid = 0, high = n - 1
        // Loop while mid <= high:
        // If nums[mid] == 0 --> swap with low, increment both low and mid
        // If nums[mid] == 1  -->  just move mid forward
        // If nums[mid] == 2  -->  swap with high, decrement high

        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}