class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] hash = new int[256]; // ASCII character set
            int length = 0;

            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] == 1) break;

                hash[s.charAt(j)] = 1;
                length = j - i + 1;
                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;
    }
}
