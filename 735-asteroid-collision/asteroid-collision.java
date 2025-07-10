class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < asteroids.length ; i++){
            int val = asteroids[i];
            if(val > 0){
                st.push(val);
            }else{
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(val)){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() > 0 && st.peek() == Math.abs(val)){
                    st.pop();
                    continue;
                }
                if(!st.isEmpty() && st.peek() > 0 && st.peek() > Math.abs(val)){
                    continue;
                }
                if(!st.isEmpty() && st.peek() < 0 && val < 0)st.push(val);
                if(st.isEmpty())st.push(val);
            }
        }

        int[] resArr = new int[st.size()];
        for(int i = st.size()-1 ; i >= 0 ; i--){
            resArr[i] = st.pop();
        }
        return resArr;
    }
}