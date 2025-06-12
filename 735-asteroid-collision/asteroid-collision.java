class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            int val = asteroids[i];

            if(val > 0){
                st.push(val);
            }else{
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < -val){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() > 0 && st.peek() == -val){
                    st.pop();
                }else if(st.isEmpty() || st.peek() < 0){
                    st.push(val);
                }
            }
        }

        int[] res = new int[st.size()];
        for(int i = st.size()-1 ; i >= 0 ; i--){
            res[i] = st.pop();
        }
        return res;
    }
}