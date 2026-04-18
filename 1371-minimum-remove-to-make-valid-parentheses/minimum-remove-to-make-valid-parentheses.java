class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();

        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            char ch = sb.charAt(i);

            if (ch == '(') {
                st.push(i);
            }
            else if (ch == ')') {
                if (!st.isEmpty()) {
                    st.pop(); // matched
                } else {
                    sb.setCharAt(i, '#'); // invalid ')'
                }
            }
        }

        // remaining '(' invalid
        while (!st.isEmpty()) {
            sb.setCharAt(st.pop(), '#');
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) != '#') {
                ans.append(sb.charAt(i));
            }
        }

        return ans.toString();
    }
}