class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        int bulbs = (brightness+2)/3;
        long sum = 0;

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> intervalcopy = new ArrayList<>();
        intervalcopy.add(intervals[0]);
        if(intervals.length>1){
        for(int i = 1 ; i < intervals.length ; i++){
            int first = intervals[i][0];
            int second = intervals[i][1];

            if(intervalcopy.get(intervalcopy.size()-1)[1]<first){
                intervalcopy.add(intervals[i]);
            }else{
                intervalcopy.get(intervalcopy.size()-1)[1] = Math.max(intervalcopy.get(intervalcopy.size()-1)[1],second);
            }
        }
        }

        for(int[] interval : intervalcopy){
            sum += interval[1] - interval[0] + 1;
        }

        return sum*bulbs;
    }
}