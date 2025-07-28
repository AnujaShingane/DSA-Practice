class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        if(hand.length%groupSize != 0){
            return false;
        }

        for(int i = 0 ; i < hand.length ; i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }

        pq.addAll(map.keySet());

        while(!pq.isEmpty()){
            int min = pq.peek();
            for(int i = 0 ; i < groupSize ; i++){
                if(map.containsKey(min)){
                    map.put(min,map.get(min)-1);
                    if(map.get(min) == 0){
                        map.remove(min);
                        pq.remove(min);
                    }
                }else{
                    return false;
                }
                min++;
            }
        }
        return true;
    }
}