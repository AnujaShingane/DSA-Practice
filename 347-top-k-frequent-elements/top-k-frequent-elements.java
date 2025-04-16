class Pair implements Comparable<Pair>{
    int key;
    int value;

    Pair(int key , int value){
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o){
        return this.value-o.value;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            pq.add(new Pair(key,map.get(key)));
             if(pq.size() > k){
                pq.remove();
            }
        }

        int[] res = new int[k];
        for(int i = 0 ; i < k ; i++){
            res[i] = pq.remove().key;
        }
        return res;
    }
}