class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for(int i = 2*n-1 ; i >= 0 ; i--){
            if(i >= n){
                while(!st.isEmpty() && st.peek() < nums[i % n]){
                    st.pop();
                }
                st.push(nums[i%n]);
            }else{
                while(!st.isEmpty() && st.peek() <= nums[i]){
                    st.pop();
                    if(st.isEmpty())res[i] = -1;
                }
                if(!st.isEmpty() && st.peek() > nums[i]){
                    res[i] = st.peek();
                }
                st.push(nums[i]);
            }
        }
        return res;
    }
}