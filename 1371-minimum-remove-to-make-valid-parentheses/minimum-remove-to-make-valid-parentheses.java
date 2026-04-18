class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0 ; i < n ; i++){
            if(sb.charAt(i)==')'){
                if(!st.isEmpty())st.pop();
                else{
                    sb.setCharAt(i,'#');
                }
            }

            if(sb.charAt(i)=='('){
                st.push(i);
            }
        }

        //remaining '(' are invalid so
        while(!st.isEmpty()){
            sb.setCharAt(st.pop(),'#');
        }
        String s2 = sb.toString();

        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < s2.length() ; i++){
            if(s2.charAt(i)!='#')ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}