class Solution {
    public int majorityElement(int[] nums) {
        // Moore's Voting Algorithm
        int ele = 0, cnt = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                ele = nums[i];
                cnt = 1;
            } else if (nums[i] == ele) {
                cnt++;
            } else {
                cnt--;
            }
        }

        // Verify the majority element
        int cnt1 = 0;
        for (int num : nums) {
            if (num == ele) cnt1++;
        }
        if (cnt1 > n / 2) {  // Fixing the verification step
            return ele;
        }
        return -1;  // This line is optional since the problem guarantees a majority element.
    }
}
