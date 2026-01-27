class Solution {
    public int leastInterval(char[] tasks, int n) {
        int n1 = tasks.length;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n1 ; i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }

        int maxFreq = 0;
        int countMax = 0;
        for(char key : map.keySet()){
            maxFreq = Math.max(maxFreq,map.get(key));
        }

        for(char key : map.keySet()){
            if(map.get(key)==maxFreq)countMax++;
        }

        //minimum intervals=max(total tasks,(maxFreq−1)×(n+1)+countMax)
        int minIntervals = Math.max(tasks.length,(maxFreq-1)*(n+1)+countMax);
        return minIntervals;
    }
}