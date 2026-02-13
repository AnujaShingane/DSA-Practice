class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);

            if(!st.isEmpty() && st.peek()==ch){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}