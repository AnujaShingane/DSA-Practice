class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> t1 = new Stack<>();

        for(int i = 0 ; i < n1 ; i++){
            if(s1.isEmpty() && s.charAt(i)=='#')continue;
            if(!s1.isEmpty() && s.charAt(i)=='#')s1.pop();
            else s1.push(s.charAt(i));
        }
        for(int i = 0 ; i < n2 ; i++){
            if(t1.isEmpty() && t.charAt(i)=='#')continue;
            if(!t1.isEmpty() && t.charAt(i)=='#')t1.pop();
            else t1.push(t.charAt(i));
        }

        return s1.equals(t1);
    }
}