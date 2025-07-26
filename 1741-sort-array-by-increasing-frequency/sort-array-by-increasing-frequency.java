class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.getValue() == b.getValue()){
                    return b.getKey() - a.getKey(); //desc
                }
                return a.getValue() - b.getValue(); //asce
            }
        );

        pq.addAll(map.entrySet());

        int[] res = new int[nums.length];
        int ind = 0;
        while(!pq.isEmpty()){
            Map.Entry<Integer,Integer> entry = pq.poll();
            int freq = entry.getValue();
            while(freq != 0){
                res[ind++] = entry.getKey();
                freq--;
            }
        }
        return res;
    }
}
