class Pair{
    int start;
    int end;
    
    Pair(int start,int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.end - b.end
        );
        
        for(int i = 0 ; i < start.length ; i++){
            pq.offer(new Pair(start[i],end[i]));
        }
        
        List<Pair> list = new ArrayList<>();
        while(!pq.isEmpty()){
            Pair entry = pq.poll();
            if(list.isEmpty()){
                list.add(entry);
            }else{
                if(list.get(list.size()-1).end < entry.start){
                    list.add(entry);
                }
            }
        }
        return list.size();
    }
}
