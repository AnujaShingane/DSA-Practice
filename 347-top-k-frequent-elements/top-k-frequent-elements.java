class Pair implements Comparable<Pair>{
    int key;
    int value;
    Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
    public int compareTo(Pair o){
        return this.value - o.value;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            pq.add(pair);
            if(pq.size() > k){
                pq.remove();
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.remove().key;
        }
        return res;
    }
}