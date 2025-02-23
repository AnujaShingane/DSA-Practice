class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '{' || ch == '(' || ch == '['){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }else{
                    char pop = st.pop();
                    if(
                        ((ch == '}' && pop != '{')||
                        (ch == ')' && pop != '(')||
                        (ch == ']' && pop != '[')) 
                    ){
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }
}