class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];

        for(int i = 0 ; i < n; i++){
            temp[i] = nums[i];
        }
        int j = 0;
        k = k%n;
        for(int i = n-k ; i < n ; i++){
            nums[j++] = temp[i];
        }
        for(int i = 0 ; i < n-k ; i++){
            nums[j++] = temp[i];
        }
    }
}