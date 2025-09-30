class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int l=0;
        int r=0;
        int cnt = 0;
        int prod = 1;
        if(k<=0)return 0;

         while (r < n) {
            prod *= nums[r];
            while (prod >= k && l <= r) {
                prod /= nums[l++];
            }
            cnt += r - l + 1;      // add once per r (after shrinking)
            r++;
        }
        return cnt;
    }
}