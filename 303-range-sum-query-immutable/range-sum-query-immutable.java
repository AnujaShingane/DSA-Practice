class NumArray {
    private int[] nums; // store original array

    public NumArray(int[] nums) {
        this.nums = nums;  // keep nums for later queries
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */