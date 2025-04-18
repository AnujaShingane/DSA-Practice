class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] res = new int[arr.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : arr){
            pq.add(num);
        }

        int cnt = 1;
        while(!pq.isEmpty()){
            int rem = pq.remove();
            if(!map.containsKey(rem))
            map.put(rem,cnt++);
        }

        for(int i = 0 ; i < res.length ; i++){
            if(map.containsKey(arr[i]))
            res[i] = map.get(arr[i]);
        }

        return res;
    }
}