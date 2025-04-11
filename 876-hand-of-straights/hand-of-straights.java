class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < hand.length ; i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int key : map.keySet()){
            minHeap.add(key);
        }

        while(!minHeap.isEmpty()){
            int min = minHeap.peek();
            for(int i = 0 ; i < groupSize ; i++){
                if(map.containsKey(min)){
                    map.put(min,map.get(min)-1);
                    if(map.get(min) == 0){
                        minHeap.remove();
                    }
                }else{
                    return false;
                }
                if(map.get(min) == 0){
                    map.remove(min);
                }
                min++;
            }
        }
        return true;
    }
}