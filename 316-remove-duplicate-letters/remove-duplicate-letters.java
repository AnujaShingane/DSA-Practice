import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] last = new int[26];          // last index of each char
        for (int i = 0; i < n; i++) last[s.charAt(i) - 'a'] = i;

        boolean[] seen = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';

            if (seen[idx]) continue;       // already in stack, skip

            // pop while we can make lexicographically smaller and still see top later
            while (!st.isEmpty()
                   && st.peek() > c
                   && last[st.peek() - 'a'] > i) {
                char popped = st.pop();
                seen[popped - 'a'] = false;
            }

            st.push(c);
            seen[idx] = true;
        }

        // build result
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();
    }
}
