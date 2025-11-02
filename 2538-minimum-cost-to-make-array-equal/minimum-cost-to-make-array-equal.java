class Solution {
    public long minCost(int[] nums, int[] cost) {
        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        for (int x : nums) { lo = Math.min(lo, x); hi = Math.max(hi, x); }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long c1 = costAt(nums, cost, mid);
            long c2 = costAt(nums, cost, mid + 1);
            if (c1 <= c2) hi = mid; else lo = mid + 1;
        }
        return costAt(nums, cost, lo);
    }
    private long costAt(int[] nums, int[] cost, int t) {
        long res = 0;
        for (int i = 0; i < nums.length; i++)
            res += 1L * cost[i] * Math.abs(nums[i] - t);
        return res;
    }
}
