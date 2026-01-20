class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int i = 1 ; i < n ; i++){
            int last = res.get(res.size()-1)[1];
            if(intervals[i][0]<=last && intervals[i][1]>=last){
                res.get(res.size()-1)[1]=intervals[i][1];
            }else if(intervals[i][0]<=last && intervals[i][1]<=last){

            }else{
                res.add(intervals[i]);
            }
        }

        int[][] finalres = new int[res.size()][2];
        for(int i = 0 ; i < res.size() ; i++){
            finalres[i] = res.get(i);
        }

        return finalres;
    }
}