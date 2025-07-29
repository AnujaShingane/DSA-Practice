public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];  // for lowercase letters a-z

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;   // increment for s
            count[t.charAt(i) - 'a']--;   // decrement for t
        }

        for (int val : count) {
            if (val != 0) return false;   // mismatch found
        }

        return true;
    }
}
