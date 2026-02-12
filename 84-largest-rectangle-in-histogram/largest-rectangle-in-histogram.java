class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int[] JNleftGreater = new int[n];
        int[] JNrightGreater = new int[n];

        JNleftGreater = JNleftGreaterr(heights);
        JNrightGreater = JNrightGreaterr(heights);

        for(int i = 0 ; i < n ; i++){
            int width = JNleftGreater[i]+JNrightGreater[i]+1;
            maxArea = Math.max(maxArea,width*heights[i]);
        }

        return maxArea;
    }

    public static int[] JNleftGreaterr(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = i;
            }else{
                res[i] = i-st.peek()-1;
            }
            st.push(i);
        }
        return res;
    }

    public static int[] JNrightGreaterr(int[] heights){
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1 ; i >= 0 ; i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = n-i-1;
            }else{
                res[i] = st.peek()-i-1;
            }

            st.push(i);
        }

        return res;
    }
}