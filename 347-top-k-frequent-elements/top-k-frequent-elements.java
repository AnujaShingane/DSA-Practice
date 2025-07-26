class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b) -> b.getValue() - a.getValue()
        );

        pq.addAll(map.entrySet());

        int[] res = new int[k];
        int ind = 0;
        while(k != 0){
            Map.Entry<Integer,Integer> entry = pq.poll();
            res[ind++] = entry.getKey();
            k--;
        }
        return res;
    }
}