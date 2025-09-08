class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);

        for(int i = 2*n-1 ; i >= 0; i--){
            int num = nums[i%n];
            while(!st.isEmpty() && st.peek() <= num){
                st.pop();
            }
            if(!st.isEmpty())res[i%n] = st.peek();
            st.push(num);
        }

        return res;
    }
}