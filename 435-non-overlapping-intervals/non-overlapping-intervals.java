class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));

        int prevEnd = intervals[0][1];
        int kept = 1;
        for(int[] arr : intervals){
            if(arr[0] >= prevEnd){
                kept++;
                prevEnd = arr[1];
            }
        }

        return intervals.length - kept;
    }
}