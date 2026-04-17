class Pair{
    char ch;
    int freq;

    Pair(char ch,int freq){
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> b.freq-a.freq
        );
        for(char key : map.keySet()){
            Pair p = new Pair(key,map.get(key));
            pq.add(p);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            char ch = p1.ch;
            int num = p1.freq;

            while(num--!=0){
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}