class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        while (true) {
            int minPos = Integer.MAX_VALUE;

            // find minimum positive
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0 && nums[i] < minPos) minPos = nums[i];
            }

            // if no positive found, we are done
            if (minPos == Integer.MAX_VALUE) break;

            // subtract that min from all positives
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) nums[i] -= minPos;
            }
            cnt++;
        }
        return cnt;
    }
}
