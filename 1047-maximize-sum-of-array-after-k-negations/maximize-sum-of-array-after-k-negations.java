class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < n ; i++){
            pq.add(nums[i]);
        }

        while(k-- != 0){
            pq.add(-(pq.remove()));
        }

        int sum=0;
        while(!pq.isEmpty()){
            sum+=pq.remove();
        }
        return sum;
    }
}