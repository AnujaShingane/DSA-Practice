class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : arr){
            pq.add(num);
        }

        int cnt = 1;
        while(!pq.isEmpty()){
            int curr = pq.remove();
            if(!map.containsKey(curr)){
                map.put(curr,cnt++);
            }
        }

        int[] res = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}