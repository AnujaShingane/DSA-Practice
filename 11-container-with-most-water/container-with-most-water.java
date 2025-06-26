class Solution {
    public int maxArea(int[] height) {
        int l = 0 , r = height.length-1;
        int maxArea = 0;
        int area = 0;
        while(l < r){
            area = (Math.min(height[l],height[r]))*(r-l);
            maxArea = Math.max(maxArea,area);
            if(height[l] < height[r])l++;
            else r--;
        }
        return maxArea;
    }
}