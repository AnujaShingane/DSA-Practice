class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n-k+1];
        int ind=0;

        for(int i = 0 ; i < n ; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            while(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.pollFirst();
            }

            dq.addLast(i);

            if(i>=k-1)res[ind++]=nums[dq.peekFirst()];
        }
        return res;
    }
}