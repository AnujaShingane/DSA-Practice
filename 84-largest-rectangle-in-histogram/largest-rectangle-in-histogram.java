class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] JNleftG = new int[n];
        int[] JNrightG = new int[n];
        int maxArea = 0;

        JNleftG = justNextLeftGreater(heights);
        JNrightG = justNextRightGreater(heights);

        for(int i = 0 ; i < n ; i++){
            int width = JNleftG[i]+JNrightG[i]+1;

            maxArea = Math.max(maxArea,width*heights[i]);
        }

        return maxArea;
    }

    /*
    func ex :-

    for -> 2 1 5 6 2 3 
    JNleftG -> 0 1 0 0 1 0
    JNrightG -> 0 4 1 0 1 0
    */

    public int[] justNextLeftGreater(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty())
                left[i] = i;          // can extend till index 0
            else
                left[i] = i - st.peek() - 1;

            st.push(i);
        }
        return left;
    }


    public int[] justNextRightGreater(int[] heights) {
        int n = heights.length;
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty())
                right[i] = n - 1 - i;     // can extend till end
            else
                right[i] = st.peek() - i - 1;

            st.push(i);
        }
        return right;
    }

}