class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points,(a,b) -> {
            if(a[1]==b[1])return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        });
        int arrows = 1;
        int lastEnd = points[0][1];

        for(int i = 1 ; i < n ; i++){
            if(points[i][0]>lastEnd){
                arrows++;
                lastEnd=points[i][1];
            }
        }

        return arrows;
    }
}