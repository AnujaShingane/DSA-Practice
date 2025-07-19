class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] freq = new int[128];  // For all ASCII characters

        // Step 1: Fill frequency of characters in t
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        int left = 0, right = 0;
        int count = t.length();  // Total characters needed
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Step 2: Start sliding window
        while (right < s.length()) {
            // Expand window
            char rChar = s.charAt(right);
            if (freq[rChar] > 0) count--;  // Needed char found
            freq[rChar]--;  // Always decrement (even if negative)

            // Step 3: Contract window from left if all required characters found
            while (count == 0) {
                // Update min window
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Shrink window
                char lChar = s.charAt(left);
                freq[lChar]++;  // Restore char
                if (freq[lChar] > 0) count++;  // Lost a required char
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
